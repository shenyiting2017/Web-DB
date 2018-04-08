package com.yiting.webdb.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiting.webdb.models.StudentScore;
import com.yiting.webdb.repos.StudentScoreRepository;

@Service
public class StudentScoreService {
	@Autowired
	private StudentScoreRepository studentScoreRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	private static final String GET_SCORE_QUERY = "SELECT StudentScore FROM StudentScore WHERE studentId = :studentId ";
	private static final String GET_SINGLE_SCORE_QUERY = "SELECT StudentScore FROM StudentScore WHERE studentId = :studentId and courseId = :courseId";

	public List<StudentScore> getStudentScores(Integer studentId) {
		List<StudentScore> studentScores = entityManager.createQuery(GET_SCORE_QUERY)
									.setParameter("studentId", studentId)
									.getResultList();
		return studentScores;
	}
	
	public StudentScore getStudentScore(Integer studentId, Integer courseId) throws Exception {
		StudentScore studentScore = (StudentScore) entityManager.createQuery(GET_SINGLE_SCORE_QUERY)
				.setParameter("studentId", studentId)
				.setParameter("courseId", courseId)
				.getSingleResult();
		return studentScore;
	}
	
	public void addStudentScore(Integer studentId, Integer courseId, Integer score) {
		StudentScore studentScore = null;
		try {
			studentScore = this.getStudentScore(studentId, courseId);
		} catch(Exception e) {
			
		}
		
		if (studentScore == null) {
			studentScore = new StudentScore();
			studentScore.setStudentId(studentId);
			studentScore.setCourseId(courseId);
		}
		
		studentScore.setScore(score);
		studentScoreRepository.save(studentScore);
	}
}
