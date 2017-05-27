package org.dlut.sample.service.user;

import java.util.List;

import org.dlut.sample.dao.user.PasswordForgetDao;
import org.dlut.sample.pojo.user.ProblemAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)

public class PasswordForgetService {
	@Autowired
	private PasswordForgetDao passwordforgetDao;
	
	public List<ProblemAnswer> inquireemail(ProblemAnswer user){
		return passwordforgetDao.inquireemail(user);
	}

}
