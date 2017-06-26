/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sms.entity.UserInfo;

/**
 * @author Balakrishna
 * @Crated on Feb 26, 2017
 * @Version 1.0
 */
public class UserInfoJpaDao extends AbstractSMSDao<UserInfo> implements IUserInfoJpaDao {

	private static final Logger log = LoggerFactory.getLogger(UserInfoJpaDao.class);

	public UserInfoJpaDao() {
		super(UserInfo.class);
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserInfoDao#registerUserInfo(com.sms.entity.UserInfo)
	 */
	@Override
	public void persistUserInfo(final UserInfo userInfo) {
		this.save(userInfo);
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserInfoDao#updateUserInfo(com.sms.entity.UserInfo)
	 */
	@Override
	public void updateUserInfo(final UserInfo userInfo) {

		log.debug("----------"+SecurityContextHolder.getContext().getAuthentication().getName()+"----------");
		try{
			this.update(userInfo);
		}catch(final Exception e){
			log.error("Exception while updating user info for user-->"
					+ SecurityContextHolder.getContext().getAuthentication().getName() + " and exception is "
					+ e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserInfoJpaDao#searchMemberDetails(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<UserInfo> searchMemberDetails(final String searchText) {

		List<UserInfo> result=null;


		Set<UserInfo> resultSet=null;

		final Criteria criteria=this.createCriteria();

		try{

			result=new ArrayList<UserInfo>();

			final Disjunction disjunction=Restrictions.disjunction();

			final String token='%'+searchText.trim().toLowerCase()+'%';

			disjunction.add(Restrictions.ilike("primFirstName", token));

			disjunction.add(Restrictions.ilike("primLastName", token));

			criteria.add(disjunction);

			result=criteria.list();

			resultSet=new HashSet<UserInfo>();

			resultSet.addAll(result);


		}catch(final DataAccessException de){
			log.error(de.getMessage(), de);
		}catch(final Exception e){
			log.error(e.getMessage(), e);
		}


		return resultSet;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.sms.dao.IUserInfoJpaDao#findUserInfoById(java.lang.Long)
	 */
	@Override
	public UserInfo findUserInfoById(final Long userInfoId) {
		final Criteria criteria = this.createCriteria();
		UserInfo userInfo = null;
		try {
			criteria.add(Restrictions.eq("userInfoId", userInfoId));
			userInfo = (UserInfo) criteria.uniqueResult();
		} catch (final Exception ex) {
			log.error(ex.getMessage(), ex);
		}
		return userInfo;
	}

}
