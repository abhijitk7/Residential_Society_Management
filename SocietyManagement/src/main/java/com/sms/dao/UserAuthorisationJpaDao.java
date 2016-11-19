/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.HibernateEntityManager;

import com.sms.entity.UserAuthorisation;

/**
 * @author Abhijit Kulkarni
 * @since 12 Nov 2016
 * @version 1.0
 */

public class UserAuthorisationJpaDao implements IUserAuthorisationJpaDao {

	@PersistenceContext(unitName = "sms")
	private EntityManager em;

	/*
	 * @see com.sms.dao.IUserAuthorisationJpaDao#finAllAuthorisedUsers()
	 */
	@Override
	public Set<UserAuthorisation> finAllAuthorisedUsers() {

		final Query query = this.em.createNamedQuery("UserAuthorisation.findAll");
		@SuppressWarnings("unchecked")
		final List<UserAuthorisation> usersList = query.getResultList();
		final Set<UserAuthorisation> result = new HashSet<UserAuthorisation>(usersList);
		return result;
	}

	/*
	 * @see com.sms.dao.IUserAuthorisationJpaDao#getAuthorisedUserById()
	 */
	@Override
	public UserAuthorisation getAuthorisedUserById(final Integer userId) {

		final Session session = ((HibernateEntityManager) this.em).getSession().getSessionFactory().openSession();

		final Criteria criteria = session.createCriteria(UserAuthorisation.class);

		criteria.add(Restrictions.eq("userId", userId));

		final UserAuthorisation user = (UserAuthorisation) criteria.list().get(0);

		return user;
	}

	/*
	 * @see com.sms.dao.IUserAuthorisationJpaDao#getAuthorisedUserByUserName()
	 */
	@Override
	public UserAuthorisation getAuthorisedUserByUserName(final String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
