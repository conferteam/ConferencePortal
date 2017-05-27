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
import org.dlut.sample.pojo.comment.CommentWithReply;
import org.dlut.sample.pojo.comment.Reply;
import org.dlut.sample.service.comment.CommentWithReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/reply")
public class ReplyAction extends BaseAction implements ModelDriven<Reply>{
	//private String confer_id = request.getParameter("confer_id");
	private Reply reply = new Reply();
	
	@Autowired
	private CommentWithReplyService commentWithReplyService;
	
	@Override
	public Reply getModel(){
		return reply;
	}

	@Action(value="insertReply",  results={@Result(name="success", location="/pages/user/UserAll.jsp", type="dispatcher")})
	public String insertReply(){

		//gbk->utf-8;
	 	 String str1=reply.getContent();
	 	 String ss="";
		    try 
		    {
		       ss=new String(str1.getBytes("ISO-8859-1"),"utf-8"); //杞爜UTF8
		    }
		    catch (UnsupportedEncodingException ex)
		    {
		        throw new RuntimeException("Unsupported encoding type.");
		    }  
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
	        reply.setContent(ss);
	        reply.setReply_date(ts);
	        request.getSession().setAttribute("user_id", 111);   //鎵嬪姩娣诲姞session锛屾ā鎷熺敤鎴风櫥褰�
	        int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());//寰楀埌褰撳墠鐢ㄦ埛鐨剈ser_id
	        reply.setFrom_id(user_id);
		    commentWithReplyService.insertReply(reply);
		    Comment comment=new Comment();
		    comment.setConfer_id(reply.getConfer_id());
		    List<Comment> commentList = commentWithReplyService.queryComment(comment);
			List<CommentWithReply> commentWithReplyList=new ArrayList<CommentWithReply>();
			CommentWithReply commentWithReply=new CommentWithReply();  
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
