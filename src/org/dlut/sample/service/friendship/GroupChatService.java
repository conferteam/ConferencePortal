package org.dlut.sample.service.friendship;

import java.util.List;

import org.dlut.sample.dao.friendship.GroupChatDao;
import org.dlut.sample.pojo.friendship.Confer;
import org.dlut.sample.pojo.friendship.GroupChat;
import org.dlut.sample.pojo.friendship.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class GroupChatService {
	@Autowired
	private GroupChatDao groupChatDao;

	public List<GroupChat> queryGroupChat(GroupChat groupChat){
		return groupChatDao.queryGroupChat(groupChat);
	}
	public Confer queryConference(GroupChat groupChat){
		return groupChatDao.queryConference(groupChat);
	}
	
	public List<User> queryUserList(GroupChat groupChat){
		return groupChatDao.queryUserList(groupChat);
	}
	public void insertGroupChat(GroupChat groupChat) {
		groupChatDao.insertGroupChat(groupChat);
	}
}
