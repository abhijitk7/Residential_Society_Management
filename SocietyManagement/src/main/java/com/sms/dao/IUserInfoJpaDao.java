/**
 * 
 */
package com.sms.dao;

import com.sms.entity.UserInfo;

/**
 * @author Balakrishna
 *
 */
public interface IUserInfoJpaDao {

	UserInfo persistUserInfo(UserInfo userInfo);
	
	String updateUserInfo(UserInfo userInfo);
}
