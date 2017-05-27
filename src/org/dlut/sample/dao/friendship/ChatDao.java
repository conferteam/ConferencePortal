package org.dlut.sample.dao.friendship;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.friendship.Messages;
import org.dlut.sample.pojo.friendship.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public List<Messages> queryChat(Messages messages){
		SqlSession session = factory.openSession();
		return session.selectList("MESSAGES.queryChat", messages);
	}
	public User queryUser(User user){
		SqlSession session = factory.openSession();
		return session.selectOne("USER.queryUser", user);
	}
	public void insertChat(Messages messages){
		SqlSession session = factory.openSession();
		session.insert("MESSAGES.insertChat", messages);
	}
	public void insertFriendNotice(Messages messages) {
		SqlSession session = factory.openSession();
		session.insert("MESSAGES.insertFriendNotice", messages);
	}
	public void acceptFriend(Messages messages) {
		SqlSession session = factory.openSession();
		session.insert("MESSAGES.addFriend", messages);
		session.delete("MESSAGES.deleteFriendNotice", messages);
	}
	public void refuseFriend(Messages messages) {
		SqlSession session = factory.openSession();
		session.delete("MESSAGES.deleteFriendNotice", messages);
	}
}
