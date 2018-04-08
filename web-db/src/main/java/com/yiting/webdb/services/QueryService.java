package com.yiting.webdb.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
	@Autowired
	private EntityManager entityManager;
	
	public List<Object[]> query(String queryStr) throws Exception {
		Query query = entityManager.createNativeQuery(queryStr);
		List<Object[]> results = query.getResultList();
		return results;
	}
}
