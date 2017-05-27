package org.dlut.sample.service.friendship;

import java.util.List;

import org.dlut.sample.dao.friendship.MessagesDao;
import org.dlut.sample.pojo.friendship.FollowConference;
import org.dlut.sample.pojo.friendship.Messages;
import org.dlut.sample.pojo.friendship.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MessagesService {
	@Autowired
	private MessagesDao messagesDao;
	
	public List<Messages> queryAll(User user) {
		return messagesDao.queryAll(user);
	}
	public List<User> queryFriends(User user) {
		return messagesDao.queryFriends(user);
	}
	public List<User> queryFollow(User user) {
		return messagesDao.queryFollow(user);
	}
	public List<User> queryBeFollowed(User user) {
		return messagesDao.queryBeFollowed(user);
	}
	public Messages queryFriendNotice(User user) {
		return messagesDao.queryFriendNotice(user);
	}
	public List<Messages> queryAllFriendNotice(User user) {
		return messagesDao.queryAllFriendNotice(user);
	}
	public FollowConference queryFollowConference(User user) {
		return messagesDao.queryFollowConference(user);
	}
	public List<FollowConference> queryAllFollowConference(User user) {
		return messagesDao.queryAllFollowConference(user);
	}
}
