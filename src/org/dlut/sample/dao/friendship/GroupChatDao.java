package org.dlut.sample.dao.friendship;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.friendship.Confer;
import org.dlut.sample.pojo.friendship.GroupChat;
import org.dlut.sample.pojo.friendship.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class GroupChatDao {

	@Autowired
	private SqlSessionFactory factory;
	
	public List<GroupChat> queryGroupChat(GroupChat groupChat) {
		SqlSession session = factory.openSession();
		return session.selectList("GROUPCHAT.queryGroupChat",groupChat);
	}

	public Confer queryConference(GroupChat groupChat) {
		SqlSession session = factory.openSession();
		return session.selectOne("CONFER.queryConference",groupChat);
	}

	public List<User> queryUserList(GroupChat groupChat) {
		SqlSession session = factory.openSession();
		return session.selectList("USER.queryUserList",groupChat);
	}

	public void insertGroupChat(GroupChat groupChat) {
		SqlSession session = factory.openSession();
		session.insert("GROUPCHAT.insertGroupChat", groupChat);
	}


}
