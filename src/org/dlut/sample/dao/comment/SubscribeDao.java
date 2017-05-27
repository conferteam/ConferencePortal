package org.dlut.sample.dao.comment;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.comment.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubscribeDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public void insertSubscribeOnce(Subscribe subscribe) {
	
		SqlSession session = factory.openSession();
		System.out.println(subscribe.toString());
		session.selectList("SUBSCRIBE.insertSubscribeOnce",subscribe);
	}
	
	public void insertSubscribeLong(Subscribe subscribe) {
		
		SqlSession session = factory.openSession();
		System.out.println(subscribe.toString());
		session.selectList("SUBSCRIBE.insertSubscribeLong",subscribe);
	}
	public void deleteSubscribeLong(Subscribe subscribe) {
		
		SqlSession session = factory.openSession();
		System.out.println(subscribe.toString());
		session.selectList("SUBSCRIBE.deleteSubscribeLong",subscribe);
	}
    public void deleteSubscribeOnce(Subscribe subscribe) {
		
		SqlSession session = factory.openSession();
		System.out.println(subscribe.toString());
		session.selectList("SUBSCRIBE.deleteSubscribeOnce",subscribe);
	}
}