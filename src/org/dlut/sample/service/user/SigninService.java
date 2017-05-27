package org.dlut.sample.service.user;

import java.util.List;

import org.dlut.sample.dao.user.SigninDao;
import org.dlut.sample.pojo.user.UserInfoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)

public class SigninService {
	@Autowired
	private SigninDao signinDao;
	
	public List<UserInfoSimple> inquire(UserInfoSimple user){
		return signinDao.inquire(user);
	}
}
