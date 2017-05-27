package org.dlut.sample.action.comment;


import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.dlut.sample.common.BaseAction;
import org.dlut.sample.pojo.comment.Comment;
import org.dlut.sample.pojo.comment.Reply;
import org.dlut.sample.pojo.comment.CommentWithReply;
import org.dlut.sample.service.comment.CommentWithReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/comment")
public class CommentWithReplyAction extends BaseAction implements ModelDriven<Comment>{
	
	private Comment comment = new Comment();
	private Reply reply =new Reply();
	private CommentWithReply commentWithReply=new CommentWithReply();
	@Autowired
	private CommentWithReplyService commentWithReplyService=new CommentWithReplyService();	
    
	@Override
	public Comment getModel() {
		return comment;
	}
	@Action(value="insertComment", results={@Result(name="success", location="/pages/comment/readmore.jsp", type="dispatcher")})
	public String insertComment(){
		System.out.println(comment);
   //gbk-》utf-8
//	    try 
//	    {
//	    	String str1=comment.getText_evaluation();
//	    	String ss=new String(str1.getBytes("ISO-8859-1"),"utf-8"); //转码UTF8
//	    	comment.setText_evaluation(ss);
//	    }
//	    catch (UnsupportedEncodingException ex)
//	    {
//	        throw new RuntimeException("Unsupported encoding type.");
//	    }  
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
        try {   
            ts = Timestamp.valueOf(dateStr);   
            System.out.println(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        //测试数据
        comment.setEvaluation_Time(ts);
        request.getSession().setAttribute("user_id", 111);   //手动添加session，模拟用户登录
        int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());//得到当前用户的user_id
        comment.setUser_id(user_id);
		commentWithReplyService.insertComment(comment);
		return "success";
	}	
	
	@Action(value="queryAll", results={@Result(name="success", location="/pages/user/UserAll.jsp", type="dispatcher")})
	public String queryAll(){
		System.out.println("-&-&--&-&--&-&--&-&--&-&--&-&--&-&--&-&-"); 
	    System.out.println(comment.getConfer_id());  
		List<Comment> commentList = commentWithReplyService.queryComment(comment);
		List<CommentWithReply> commentWithReplyList=new ArrayList<CommentWithReply>();
	    System.out.println(commentList.size());   
	    for(int i=0;i<commentList.size();i++)
	    {
	    	reply.setEvaluation_id(commentList.get(i).getEvaluation_id());
	    	List<Reply> replyList=commentWithReplyService.queryReply(reply);
	    	commentWithReply=new CommentWithReply(commentList.get(i),replyList);
	    	commentWithReplyList.add(commentWithReply);
	    }
		request.setAttribute("commentWithReplyList",  commentWithReplyList);
		return "success";
	}
}

