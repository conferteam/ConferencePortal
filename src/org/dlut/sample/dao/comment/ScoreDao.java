package org.dlut.sample.dao.comment;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dlut.sample.pojo.comment.Conference;
import org.dlut.sample.pojo.comment.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDao {
	@Autowired
	private SqlSessionFactory factory;
	
	public void updateScore(Score score) {
		SqlSession session = factory.openSession();
		System.out.println(score.toString());
		session.selectList("SCORE.updateScore",score);
	}
	public List<Score> query(Score score) {
		SqlSession session = factory.openSession();
		return session.selectList("SCORE.query",score);
	}
	public List<Score> queryValidScore(Score score) {
		SqlSession session = factory.openSession();
		return session.selectList("SCORE.queryValidScore",score);
	}
	public void updateAverageScore(Conference conference) {
		SqlSession session = factory.openSession();
		System.out.println(conference.toString());
		session.selectList("SCORE.updateAverageScore",conference);
	}
}