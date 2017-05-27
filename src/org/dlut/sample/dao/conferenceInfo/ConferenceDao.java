package org.dlut.sample.dao.conferenceInfo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.conferenceInfo.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConferenceDao {
	@Autowired
	private SqlSessionFactory factory;
	
	/**
	 * 插入会议
	 * @param conference
	 */
	public void insert(Conference conference){
		SqlSession session = factory.openSession();
		session.insert("CONFERENCE.insert", conference);
	}
	
	/**
	 * 查询已发布的会议
	 * @return
	 */
	public List<Conference> queryCFP() {
		System.out.println("ConferenceDao");
		SqlSession session = factory.openSession();
		System.out.println(session.selectList("CONFERENCE.queryCFP"));
		return session.selectList("CONFERENCE.queryCFP");
	}
	
	/**
	 * 查询新发布的会议
	 * @return
	 */
	public List<Conference> queryByDate() {
		System.out.println("ConferenceDaoDate");
		SqlSession session = factory.openSession();
		System.out.println(session.selectList("CONFERENCE.queryByDate"));
		return session.selectList("CONFERENCE.queryByDate");
	}
	
	/**
	 * 查询会议所有类别
	 * @return
	 */
	public List<Conference> queryCategories() {
		System.out.println("ConferenceDaoCategories");
		SqlSession session = factory.openSession();
		System.out.println(session.selectList("CONFERENCE.queryCategories"));
		return session.selectList("CONFERENCE.queryCategories");
	}
	
	/**
	 * 按会议类别进行查询
	 * @return
	 */
	public List<Conference> queryByCategories(Conference conference) {
		//Conference conference = new Conference();
		//conference.setCategories_id(cate);
		System.out.println("DaoByCategories");
		SqlSession session = factory.openSession();
		//session.
		System.out.println(session.selectList("CONFERENCE.queryByCategories",conference));
		//System.out.println(conference.toString());
		return session.selectList("CONFERENCE.queryByCategories",conference);
		
	}
	
	/**
	 * 查询会议详细信息
	 * @return
	 */
	public List<Conference> queryDetail(Conference conference) {
		System.out.println("--------DaoDetail----------");
		SqlSession session = factory.openSession();
		System.out.println(session.selectList("CONFERENCE.queryDetail",conference));
		//System.out.println(conference.toString());
		return session.selectList("CONFERENCE.queryDetail",conference);
		
	}

	public void updateCFP(Conference conference) {
		SqlSession session = factory.openSession();
		System.out.println("--------DaoUpdate----------");		
		session.update("CONFERENCE.updateCFP", conference);
		/*SqlSession session = factory.openSession();*/
		//System.out.println(session.selectList("CONFERENCE.updateCFP",conference));
		//System.out.println(conference.toString());
		//return session.
		/*return session.selectList("CONFERENCE.queryDetail",conference);*/
	}

	public List<Conference> queryById(Conference conference) {
		SqlSession session = factory.openSession();
		System.out.println(session.selectList("CONFERENCE.queryById",conference));
		return session.selectList("CONFERENCE.queryById",conference);
	}
	
}
