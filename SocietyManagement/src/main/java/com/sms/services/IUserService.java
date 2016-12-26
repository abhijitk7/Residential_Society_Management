/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.services;

import java.util.Set;

import com.sms.entity.User;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */
public interface IUserService {

	User getAuthorisedUserById(Integer userId);

	String getAuthorisedUserByNameAndPassword(String userName, String passWord);

	Set<User> getAllAuthorisedUsers();
	
	String createUser(User user);
	
	String updateLastLogOn(Long userId);
}
