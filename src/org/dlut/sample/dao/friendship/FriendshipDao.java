package org.dlut.sample.dao.friendship;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.friendship.Friendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FriendshipDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public void insertFollow(Friendship friendship){
		SqlSession session = factory.openSession();
		session.insert("USER.insertFollow", friendship);
	}

	public void deleteFollow(Friendship friendship) {
		SqlSession session = factory.openSession();
		session.delete("USER.deleteFollow", friendship);
	}

	public void deleteFriend(Friendship friendship) {
		SqlSession session = factory.openSession();
		session.delete("USER.deleteFriend", friendship);
	}

	public void deleteChat(Friendship friendship) {
		SqlSession session = factory.openSession();
		session.delete("USER.deleteChat", friendship);
	}

}
