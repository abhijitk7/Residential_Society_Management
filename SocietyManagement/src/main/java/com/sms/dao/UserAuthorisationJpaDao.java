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

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.sms.entity.UserAuthorisation;

/**
 * @author Abhijit Kulkarni
 * @since 12 Nov 2016
 * @version 1.0
 */

public class UserAuthorisationJpaDao extends AbstractSMSDao<UserAuthorisation> implements IUserAuthorisationJpaDao {

	/**
	 * @param ec
	 */
	public UserAuthorisationJpaDao() {
		super(UserAuthorisation.class);
	}

	/*
	 * @see com.sms.dao.IUserAuthorisationJpaDao#finAllAuthorisedUsers()
	 */
	@Override
	public Set<UserAuthorisation> finAllAuthorisedUsers() {

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
	public UserAuthorisation getAuthorisedUserById(final Integer userId) {

		// final Session session = ((HibernateEntityManager)
		// this.em).getSession().getSessionFactory().openSession();
		//
		// final Criteria criteria =
		// session.createCriteria(UserAuthorisation.class);
		//
		// criteria.add(Restrictions.eq("userId", userId));
		//
		// final UserAuthorisation user = (UserAuthorisation)
		// criteria.list().get(0);

		return null;
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
		final UserAuthorisation user = (UserAuthorisation) criteria.uniqueResult();
		if (user != null && user.getUserName().equals(userName) && passWord.equals(passWord)) {
			result = "true";
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserAuthorisationJpaDao#saveUserAuthDetails(com.sms.entity.UserAuthorisation)
	 */
	@Override
	public String saveUserAuthDetails(UserAuthorisation user) {

		String persistStatus = "true";
		try {
			save(user);
		} catch (EntityExistsException e) {
			//persistStatus = "User Already Exists";
			persistStatus = "false";
		} catch (PersistenceException e) {
			//persistStatus = "Issue while persisting data";
			persistStatus = "false";
		} catch (Exception e) {
			//persistStatus = "Some unknown error has occurred";
			persistStatus = "false";
		}
		return persistStatus;
	}
	
	
}
