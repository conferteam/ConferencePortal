package org.dlut.sample.service.friendship;

import org.dlut.sample.dao.friendship.FriendshipDao;
import org.dlut.sample.pojo.friendship.Friendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class FriendshipService {
	@Autowired
	private FriendshipDao friendshipDao;
	
	public void insertFollow(Friendship friendship) {
		friendshipDao.insertFollow(friendship);
	}

	public void deleteFollow(Friendship friendship) {
		friendshipDao.deleteFollow(friendship);
	}

	public void deleteFriend(Friendship friendship) {
		friendshipDao.deleteFriend(friendship);
	}

	public void deleteChat(Friendship friendship) {
		friendshipDao.deleteChat(friendship);
	}

}
