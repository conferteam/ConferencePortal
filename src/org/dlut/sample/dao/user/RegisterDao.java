package org.dlut.sample.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.user.UserInfoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<UserInfoSimple> inquire(UserInfoSimple user){
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.inquireregister",user);
	}
	
	public void insert(UserInfoSimple user){
		SqlSession session = factory.openSession();
		session.insert("USERINFO.insert", user);
	}

}
