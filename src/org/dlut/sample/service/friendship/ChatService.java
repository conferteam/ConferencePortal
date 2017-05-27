package org.dlut.sample.service.friendship;

import java.util.List;

import org.dlut.sample.dao.friendship.ChatDao;
import org.dlut.sample.pojo.friendship.Messages;
import org.dlut.sample.pojo.friendship.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class ChatService {
	@Autowired
	private ChatDao chatDao;

	public List<Messages> queryChat(Messages messages){
		return chatDao.queryChat(messages);
	}
	public User queryUser(User user){
		return chatDao.queryUser(user);
	}
	
	public void insertChat(Messages messages){
		chatDao.insertChat(messages);
		
	}
	public void insertFriendNotice(Messages messages) {
		chatDao.insertFriendNotice(messages);
	}
	public void acceptFriend(Messages messages) {
		chatDao.acceptFriend(messages);
	}
	public void refuseFriend(Messages messages) {
		chatDao.refuseFriend(messages);
	}
}
