package com.aspl.org.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aspl.org.dao.AppUserDAO;
import com.aspl.org.entity.AppUser;

@Repository
@Transactional
public class AppUserDAOImpl implements AppUserDAO {

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public AppUser findUserAccount(String userName) {
		 try {
	            String sql = "Select e from " + AppUser.class.getName() + " e " //
	                    + " Where e.userName = :userName ";
	 
	            Query query = entityManager.createQuery(sql, AppUser.class);
	            query.setParameter("userName", userName);
	 
	            return (AppUser) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	    }
	

}
