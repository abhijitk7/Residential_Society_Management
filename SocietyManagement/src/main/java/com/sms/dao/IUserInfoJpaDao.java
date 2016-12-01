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
	UserInfo updateUserInfo(UserInfo updateUserInfo);
}
