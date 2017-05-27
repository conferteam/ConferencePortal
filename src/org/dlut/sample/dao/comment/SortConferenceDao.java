package org.dlut.sample.dao.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.comment.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SortConferenceDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<Conference> sortConference(Conference conference) {
	
		SqlSession session = factory.openSession();
		System.out.println(conference.toString());
		return session.selectList("CONFERENCESORT.sortConference",conference);
	}
}