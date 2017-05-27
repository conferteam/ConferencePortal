package org.dlut.sample.dao.friendship;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.friendship.FollowConference;
import org.dlut.sample.pojo.friendship.Messages;
import org.dlut.sample.pojo.friendship.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessagesDao {
	@Autowired
	private SqlSessionFactory factory;

	public List<Messages> queryAll(User user) {
		SqlSession session = factory.openSession();
		return session.selectList("MESSAGES.queryAll",user);
	}
	public List<User> queryFriends(User user) {
		SqlSession session = factory.openSession();
		return session.selectList("USER.queryFriends",user);
	}
	public List<User> queryFollow(User user) {
		SqlSession session = factory.openSession();
		return session.selectList("USER.queryFollow",user);
	}
	public List<User> queryBeFollowed(User user) {
		SqlSession session = factory.openSession();
		return session.selectList("USER.queryBeFollowed",user);
	}
	public Messages queryFriendNotice(User user) {
		SqlSession session = factory.openSession();
		return session.selectOne("MESSAGES.queryFriendNotice",user);
	}
	public List<Messages> queryAllFriendNotice(User user) {
		SqlSession session = factory.openSession();
		return session.selectList("MESSAGES.queryAllFriendNotice",user);
	}
	public FollowConference queryFollowConference(User user) {
		SqlSession session = factory.openSession();
		return session.selectOne("FOLLOWCONFERENCE.queryFollowConference",user);
	}
	public List<FollowConference> queryAllFollowConference(User user) {
		SqlSession session = factory.openSession();
		return session.selectList("FOLLOWCONFERENCE.queryAllFollowConference",user);
	}
}
