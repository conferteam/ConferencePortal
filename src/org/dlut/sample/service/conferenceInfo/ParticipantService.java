package org.dlut.sample.service.conferenceInfo;

import org.dlut.sample.dao.conferenceInfo.ParticipantDao;
import org.dlut.sample.pojo.conferenceInfo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ParticipantService {

	@Autowired
	private ParticipantDao participantDao;
	
	public void insert(Participant participant) {
		participantDao.insert(participant);
	}
	
}
