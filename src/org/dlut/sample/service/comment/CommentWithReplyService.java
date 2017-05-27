package org.dlut.sample.service.comment;

import java.util.List;

import org.dlut.sample.dao.comment.CommentWithReplyDao;
import org.dlut.sample.pojo.comment.Comment;
import org.dlut.sample.pojo.comment.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentWithReplyService {
	@Autowired
	private CommentWithReplyDao commentWithReplyDao ;
	
	public List<Comment> queryComment(Comment comment) {
		System.out.println("service");  
	    System.out.println(comment.getConfer_id());  
		return commentWithReplyDao.queryComment(comment);
	}
	
	public List<Reply> queryReply(Reply reply) {
		System.out.println("service");  
	    System.out.println(reply.getEvaluation_id());  
		return commentWithReplyDao.queryReply(reply);
	}
	public void insertComment(Comment comment){
		commentWithReplyDao.insertComment(comment);
	}
	public void insertReply(Reply reply){
		commentWithReplyDao.insertReply(reply);
	}
}