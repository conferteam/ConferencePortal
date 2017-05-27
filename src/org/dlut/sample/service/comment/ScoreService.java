package org.dlut.sample.service.comment;


import java.util.List;

import org.dlut.sample.dao.comment.ScoreDao;
import org.dlut.sample.pojo.comment.Conference;
import org.dlut.sample.pojo.comment.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScoreService {
	@Autowired
	private ScoreDao scoreDao ;
	
	public void updateScore(Score score) {	
		 scoreDao.updateScore(score);
	}
	public List<Score> query(Score score) {
		return scoreDao.query(score);
	}
	public List<Score> queryValidScore(Score score) {
		return scoreDao.query(score);
	}
	public void updateAverageScore(Conference conference) {	
		 scoreDao.updateAverageScore(conference);
	}
}