package com.aperture.user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aperture.user.entity.UserImpl;

@Repository
public class UserDao {

	@Autowired
	private EntityManager entityManager;
	
	public List<UserImpl> getAllUsers() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<UserImpl> criteriaQuery = criteriaBuilder.createQuery(UserImpl.class);
		final Root<UserImpl> root = criteriaQuery.from(UserImpl.class);
		criteriaQuery.select(root);
		final TypedQuery<UserImpl> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public UserImpl getUserById(Long userId) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<UserImpl> criteriaQuery = criteriaBuilder.createQuery(UserImpl.class);
		final Root<UserImpl> root = criteriaQuery.from(UserImpl.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("userId"), userId));
		final TypedQuery<UserImpl> query = entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();
	}
	
}
