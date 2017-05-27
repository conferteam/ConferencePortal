package org.dlut.sample.service.user;

import java.util.List;

import org.dlut.sample.dao.user.RegisterDao;
import org.dlut.sample.pojo.user.UserInfoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)

public class RegisterService {
	@Autowired
	private RegisterDao registerDao;
	
	public void insert(UserInfoSimple user){
		registerDao.insert(user);
	}
	
	public List<UserInfoSimple> inquire(UserInfoSimple user){
		return registerDao.inquire(user);
	}

}
