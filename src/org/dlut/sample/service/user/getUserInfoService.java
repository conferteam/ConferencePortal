package org.dlut.sample.service.user;

import java.util.List;

import org.dlut.sample.dao.user.getUserInfoDao;
import org.dlut.sample.pojo.user.ConferInfoSimple;
import org.dlut.sample.pojo.user.ProblemAnswer;
import org.dlut.sample.pojo.user.UserInfo;
import org.dlut.sample.pojo.user.UserInfoPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)

public class getUserInfoService {
	@Autowired
	private getUserInfoDao getuserinfoDao;
	
/*	public void insertAvatar(UserInfo user){
		getuserinfoDao.insertAvatar(user);
	}*/
	
	public List<ConferInfoSimple> getMySubscribe(UserInfoPages pages){
		return getuserinfoDao.getMySubscribe(pages);
	}
	
	public Integer getMySubscribeCount(Integer id){
		return getuserinfoDao.getMySubscribeCount(id);
	}
	
	public List<ConferInfoSimple> getMyConfer(UserInfoPages pages){
		return getuserinfoDao.getMyConfer(pages);
	}
	
	public Integer getMyConferCount(Integer id){
		return getuserinfoDao.getMyConferCount(id);
	}
	
	public List<ConferInfoSimple> getConferAll(UserInfoPages pages){
		return getuserinfoDao.getConferAll(pages);
	}
	
	public Integer getConferCount(){
		return getuserinfoDao.getConferCount();
	}
	
	public List<ConferInfoSimple> getMySubscribeTop2(UserInfo user){
		return getuserinfoDao.getMySubscribeTop2(user);
	}
	
	public List<ConferInfoSimple> getMyConferTop2(UserInfo user){
		return getuserinfoDao.getMyConferTop2(user);
	}
	
	public void passwordreset(UserInfo user){
		getuserinfoDao.passwordreset(user);
	}
	
	public List<ProblemAnswer> inquireproblem(ProblemAnswer user){
		return getuserinfoDao.inquireproblem(user);
	}
	
	public void insertproblem(ProblemAnswer user){
		getuserinfoDao.insertproblem(user);
	}
	
	public List<UserInfo> inquire(UserInfo user){
		return getuserinfoDao.inquire(user);
	}
	
	public void insert(UserInfo user){
		getuserinfoDao.insert(user);
	}
	
	public void insertnopassword(UserInfo user){
		getuserinfoDao.insertnopassword(user);
	}

}
