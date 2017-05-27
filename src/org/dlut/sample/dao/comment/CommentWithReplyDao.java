package org.dlut.sample.dao.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.comment.Comment;
import org.dlut.sample.pojo.comment.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentWithReplyDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<Comment> queryComment(Comment comment) {
		System.out.println("Dao");  
	    System.out.println(comment.getConfer_id());  
		SqlSession session = factory.openSession();
		System.out.println(comment.toString());
		return session.selectList("COMMENT.queryComment",comment);
	}
	public List<Reply> queryReply(Reply reply) {
		System.out.println("Dao");  
	    System.out.println(reply.getEvaluation_id());  
		SqlSession session = factory.openSession();
		System.out.println(reply.toString());
		return session.selectList("REPLY.queryReply",reply);
	}
	public void insertComment(Comment comment){
		SqlSession session = factory.openSession();
		session.insert("COMMENT.insertComment", comment);		
	}
	public void insertReply(Reply reply){
		SqlSession session = factory.openSession();
		session.insert("REPLY.insertReply", reply);		
	}

}