package org.dlut.sample.service.conferenceInfo;

import java.util.List;

import org.dlut.sample.dao.conferenceInfo.ConferenceDao;
import org.dlut.sample.pojo.conferenceInfo.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ConferenceService {

	@Autowired
	private ConferenceDao conferenceDao;
	
	public void insert(Conference conference) {
		conferenceDao.insert(conference);
	}
	
	public List<Conference> queryCFP(){
		System.out.println("ConferenceService");
		return conferenceDao.queryCFP();
	}
	
	public List<Conference> queryByDate(){
		System.out.println("ConferenceServiceDate");
		return conferenceDao.queryByDate();
	}
	
	public List<Conference> queryCategories(){
		System.out.println("ConferenceServiceCategories");
		return conferenceDao.queryCategories();
	}
	
	public List<Conference> queryByCategories(Conference conference) {
		System.out.println("ServiceByCategories");
		return conferenceDao.queryByCategories(conference);
	}
	
	public List<Conference> queryDetail(Conference conference) {
		System.out.println("ServiceDetail------");
		return conferenceDao.queryDetail(conference);
	}

	public void updateCFP(Conference conference) {
		System.out.println("-----------updateService------");
		conferenceDao.updateCFP(conference);
	}

	public List<Conference> queryById(Conference conference) {
		return conferenceDao.queryById(conference);
	}
	
}
