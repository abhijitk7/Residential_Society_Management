/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.Set;

import com.sms.entity.UserAuthorisation;

/**
 * @author Abhijit Kulkarni
 * @since 12 Nov 2016
 * @version 1.0
 */

public interface IUserAuthorisationJpaDao {

	Set<UserAuthorisation> finAllAuthorisedUsers();

	UserAuthorisation getAuthorisedUserById(Integer userId);

	String getAuthorisedUserByUserNameAndPassword(String userName, String passWord);
	
	String saveUserAuthDetails(UserAuthorisation user);

}
