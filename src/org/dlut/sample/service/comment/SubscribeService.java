package org.dlut.sample.service.comment;


import org.dlut.sample.dao.comment.SubscribeDao;
import org.dlut.sample.pojo.comment.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SubscribeService {
	@Autowired
	private SubscribeDao subscribeDao ;
	
	public void insertSubscribeOnce(Subscribe subscribe) {	
		 subscribeDao.insertSubscribeOnce(subscribe);
	}
	public void insertSubscribeLong(Subscribe subscribe) {	
		 subscribeDao.insertSubscribeLong(subscribe);
	}
	public void deleteSubscribeLong(Subscribe subscribe) {	
		 subscribeDao.deleteSubscribeLong(subscribe);
	}
	public void deleteSubscribeOnce(Subscribe subscribe) {	
		 subscribeDao.deleteSubscribeOnce(subscribe);
	}
}