package org.dlut.sample.service.comment;

import java.util.List;



import org.dlut.sample.dao.comment.SortConferenceDao;
import org.dlut.sample.pojo.comment.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SortConferenceService {
	@Autowired
	private SortConferenceDao sortConferenceDao ;
	
	public List<Conference> sortConference(Conference conference) {	
		return sortConferenceDao.sortConference(conference);
	}
}