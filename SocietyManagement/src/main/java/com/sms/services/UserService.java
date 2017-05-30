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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.sms.dao.IUserInfoJpaDao;
import com.sms.dao.IUserJpaDao;
import com.sms.entity.User;
import com.sms.entity.UserInfo;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */
public class UserService implements IUserService {

	@Autowired
	private IUserJpaDao userDao;
	
	@Autowired
	private IUserInfoJpaDao userInfoDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sms.services.IUserService#getAuthorisedUserById(java.lang.Integer)
	 */
	@Override
	public User getAuthorisedUserById(final Long userId) {

		final User authUser = this.userDao.getAuthorisedUserById(userId);
		return authUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sms.services.IUserService#getAllAuthorisedUsers()
	 */
	@Override
	public Set<User> getAllAuthorisedUsers() {
		return this.userDao.finAllAuthorisedUsers();
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
		return this.userDao.getAuthorisedUserByUserNameAndPassword(userName, passWord);
	}

	/* (non-Javadoc)
	 * @see com.sms.services.IUserService#createUser(com.sms.entity.UserAuthorisation)
	 */
	@Override
	@Transactional
	public String createUser(User user) {
		
		//Encrypt the password before saving
		user.setPassword(passwordEncoder.encode(user.getPassWord()));
		
		return this.userDao.saveUserAuthDetails(user);
	}

	@Override
	@Transactional
	public String updateLastLogOn(Long userId) {
		return this.userDao.updateLastLogOnInfo(userId);
	}

	@Override
	@Transactional
	public void updateUserInfo(UserInfo userInfo) {
		try{
			this.userInfoDao.updateUserInfo(userInfo);
		}catch(Exception ex){
			throw ex;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.sms.services.IUserService#searchUserDetails(java.lang.String)
	 */
	@Override
	@Transactional
	public Set<UserInfo> searchUserDetails(String searchText) {
		
		return userInfoDao.searchMemberDetails(searchText);
	}
}