/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.dao.UserAuthorisationJpaDao;
import com.sms.entity.UserAuthorisation;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */
public class UserService implements IUserService {

	@Autowired
	private UserAuthorisationJpaDao userAuthDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sms.services.IUserService#getAuthorisedUserById(java.lang.Integer)
	 */
	@Override
	public UserAuthorisation getAuthorisedUserById(final Integer userId) {

		final UserAuthorisation authUser = this.userAuthDao.getAuthorisedUserById(userId);
		return authUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sms.services.IUserService#getAllAuthorisedUsers()
	 */
	@Override
	public Set<UserAuthorisation> getAllAuthorisedUsers() {
		return this.userAuthDao.finAllAuthorisedUsers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.sms.services.IUserService#getAuthorisedUserByNameAndPassword(java
	 * .lang.Integer)
	 */
	@Override
	public String getAuthorisedUserByNameAndPassword(final String userName, final String passWord) {
		return this.userAuthDao.getAuthorisedUserByUserNameAndPassword(userName, passWord);
	}

	/* (non-Javadoc)
	 * @see com.sms.services.IUserService#createUser(com.sms.entity.UserAuthorisation)
	 */
	@Override
	public String createUser(UserAuthorisation user) {
		return this.userAuthDao.saveUserAuthDetails(user);
	}
}
