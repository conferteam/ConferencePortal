package org.dlut.sample.dao.conferenceInfo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.conferenceInfo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantDao {

	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Participant participant){
		SqlSession session = factory.openSession();
		session.insert("PARTICIPANT.insertParticipant", participant);
	}
	
	
}

