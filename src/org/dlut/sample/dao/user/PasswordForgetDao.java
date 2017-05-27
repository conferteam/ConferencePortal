package org.dlut.sample.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.user.ProblemAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordForgetDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<ProblemAnswer> inquireemail(ProblemAnswer user){
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.probleminquireemail",user);
	}
}
