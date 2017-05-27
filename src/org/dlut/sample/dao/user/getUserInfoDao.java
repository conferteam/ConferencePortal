package org.dlut.sample.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.user.ConferInfoSimple;
import org.dlut.sample.pojo.user.ProblemAnswer;
import org.dlut.sample.pojo.user.UserInfo;
import org.dlut.sample.pojo.user.UserInfoPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class getUserInfoDao {
	@Autowired
	private SqlSessionFactory factory;

	/*
	 * public void insertAvatar(UserInfo user){ SqlSession session =
	 * factory.openSession(); session.selectList("USERINFO.insertAvatar", user);
	 * }
	 */
	
	public List<ConferInfoSimple> getMySubscribe(UserInfoPages pages){
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.getmysubscribe",pages);
	}
	
	public Integer getMySubscribeCount(Integer id){ //用于获取我参与的会议个数
		SqlSession session= factory.openSession();
		return session.selectOne("USERINFO.getmysubscribecount",id);
	}
	
	public List<ConferInfoSimple> getMyConfer(UserInfoPages pages){
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.getmyconfer",pages);
	}
	
	public Integer getMyConferCount(Integer id){ //用于获取我参与的会议个数
		SqlSession session= factory.openSession();
		return session.selectOne("USERINFO.getmyconfercount",id);
	}
	
	public List<ConferInfoSimple> getConferAll(UserInfoPages pages){
		SqlSession session =factory.openSession();
		return session.selectList("USERINFO.getconferall",pages);
	}
	
	public Integer getConferCount(){
		SqlSession session = factory.openSession();
		return session.selectOne("USERINFO.getconfercount");
	}

	public List<ConferInfoSimple> getMySubscribeTop2(UserInfo user) {
		SqlSession session = factory.openSession();
		List<ConferInfoSimple> templist = session.selectList("USERINFO.getmysubscribetop2", user); // 暂时获取只有confer_id的数据
		for (int i = 0; i < templist.size(); i++) { // 遍历list
			templist.set(i, (ConferInfoSimple) session.selectList("USERINFO.conferidexchangename", templist.get(i)).get(0)); // 根据confer_id添加confer_name
		}
		return templist;
	}

	public List<ConferInfoSimple> getMyConferTop2(UserInfo user) {
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.getmyconfertop2", user);
	}

	public void passwordreset(UserInfo user) {
		SqlSession session = factory.openSession();
		session.selectList("USERINFO.passwordreset", user);
	}

	public List<ProblemAnswer> inquireproblem(ProblemAnswer user) {
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.inquireproblem", user);
	}

	public void insertproblem(ProblemAnswer user) {
		SqlSession session = factory.openSession();
		session.selectList("USERINFO.insertproblem", user);
	}

	public List<UserInfo> inquire(UserInfo user) {
		SqlSession session = factory.openSession();
		return session.selectList("USERINFO.inquireuserinfo", user);
	}

	public void insert(UserInfo user) {
		SqlSession session = factory.openSession();
		session.selectList("USER.insertnewinfo", user);
	}

	public void insertnopassword(UserInfo user) {
		SqlSession session = factory.openSession();
		session.selectList("USER.insertnewinfonopassword", user);
	}
}