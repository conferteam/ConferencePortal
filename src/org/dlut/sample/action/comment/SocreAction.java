package org.dlut.sample.action.comment;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.comment.Conference;
import org.dlut.sample.pojo.comment.Score;
import org.dlut.sample.service.comment.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/score")
public class SocreAction extends BaseAction implements ModelDriven<Score>{
	private Score score = new Score();
	
	@Autowired
	private ScoreService scoreService;
	
	@Override
	public Score getModel(){
		return score;
	}
	@Action(value="updateScore", results={@Result(name="success", location="/pages/byCategories.jsp", type="dispatcher")})
	public String updateScore(){
		request.getSession().setAttribute("user_id", 111);     //测试数据
		int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
		score.setUser_id(user_id);
		List<Score> temp=scoreService.query(score);
		Date date = new Date();
		//Date->String
		String dateStr = "";           
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        try {   
            dateStr = sdf.format(date);   
            System.out.println(dateStr);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
	    //String->TimeStamp
        Timestamp ts = new Timestamp(System.currentTimeMillis());   
        try 
        {   
            ts = Timestamp.valueOf(dateStr);   
            System.out.println(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
		if(temp.get(0).getConfer_date().getTime()>ts.getTime()) 
			;//已经举行不能再评分
		else//没有举行，可以评分。
		{
			if(temp.size()==1)//用户参会，允许评分
			{
				if(temp.get(0).getScore_times().equals(0))
				{
			         scoreService.updateScore(score);
			         //更新会议平均分
			         List<Score> validScore =scoreService.queryValidScore(score);//获取该会议的所有有效评分
			         Integer sum=0;
			         Integer count=0;
			         for(count=0;count<validScore.size();count++)
			         {
			        	 sum+=validScore.get(count).getEvaluation_score();		        	 
			         }
			         float average=sum/count;
			         Conference newAverageValide=new Conference();
			         newAverageValide.setConfer_score(average);
			         newAverageValide.setConference_id(score.getConfer_id());
			         scoreService.updateAverageScore(newAverageValide);
				}
				else  ;//已经评过分，不允许再次评分;
			}
			else;//用户未参会，不允许评分		
		}
	   
		return "success";
	}
}