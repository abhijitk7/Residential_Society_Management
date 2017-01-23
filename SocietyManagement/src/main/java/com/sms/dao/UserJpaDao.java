/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.sms.entity.User;

/**
 * @author Abhijit Kulkarni
 * @since 12 Nov 2016
 * @version 1.0
 */

public class UserJpaDao extends AbstractSMSDao<User> implements IUserJpaDao {

	/**
	 * @param ec
	 */
	public UserJpaDao() {
		super(User.class);
	}

	/*
	 * @see com.sms.dao.IUserAuthorisationJpaDao#finAllAuthorisedUsers()
	 */
	@Override
	public Set<User> finAllAuthorisedUsers() {

		// final Criteria criteria = this.createCriteria();
		//
		// final Query query =
		// this.em.createNamedQuery("UserAuthorisation.findAll");
		// @SuppressWarnings("unchecked")
		// final List<UserAuthorisation> usersList = query.getResultList();
		// final Set<UserAuthorisation> result = new
		// HashSet<UserAuthorisation>(usersList);
		return null;
	}

	/*
	 * @see com.sms.dao.IUserAuthorisationJpaDao#getAuthorisedUserById()
	 */
	@Override
	public User getAuthorisedUserById(final Long userId) {

		Criteria criteria=createCriteria();
		criteria.add(Restrictions.eq("userId", userId));
		final User user = (User) criteria.uniqueResult();
		return user;
	}

	/*
	 * @see
	 * com.sms.dao.IUserAuthorisationJpaDao#getAuthorisedUserByUserNameAndPassword
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public String getAuthorisedUserByUserNameAndPassword(final String userName, final String passWord) {

		final Criteria criteria = this.createCriteria();
		String result = "false";
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("passWord", passWord));
		final User user = (User) criteria.uniqueResult();
		if (user != null && user.getUserName().equals(userName) && passWord.equals(passWord)) {
			result = "true";
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserAuthorisationJpaDao#saveUserAuthDetails(com.sms.entity.User)
	 */
	@Override
	public String saveUserAuthDetails(User user) {

		String persistStatus = "true";
		try {
			save(user);
		} catch (EntityExistsException e) {
			//persistStatus = "User Already Exists";
			e.printStackTrace();
			persistStatus = "false";
		} catch (PersistenceException e) {
			//persistStatus = "Issue while persisting data";
			persistStatus = "false";
			e.printStackTrace();
		} catch (Exception e) {
			//persistStatus = "Some unknown error has occurred";
			e.printStackTrace();
			persistStatus = "false";
		}
		return persistStatus;
	}

	@Override
	public User getAuthorisedUserByName(String userName) {
		
		final Criteria criteria = this.createCriteria();

		criteria.add(Restrictions.eq("userName", userName));
		final User user = (User) criteria.uniqueResult();
		
		return user;
	}

	@Override
	public String updateLastLogOnInfo(Long userId) {
		
		Query query=getEm().createQuery("Update User set lastUpdateDate=:updateDateTime Where userId=:userId");
		
		query.setParameter("updateDateTime", new java.util.Date());
		query.setParameter("userId", userId);
		
		if(query.executeUpdate()==1){
			return "True";
		}else{
			return "False";
		}
		
		
	}
	
	
}
