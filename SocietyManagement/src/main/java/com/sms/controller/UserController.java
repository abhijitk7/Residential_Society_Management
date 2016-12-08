/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sms.entity.UserAuthorisation;
import com.sms.services.IUserService;

/**
 * @author Abhijit Kulkarni
 * @since 12 Nov 2016
 * @version 1.0
 */

@Controller
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/UserById/{userId}", method = RequestMethod.GET)
	ResponseEntity<UserAuthorisation> getUserById(@PathVariable final String userId) {
		log.debug("********** Retriving all Amenities ****************");
		final UserAuthorisation user = this.userService.getAuthorisedUserById(Integer.parseInt(userId));
		return new ResponseEntity<UserAuthorisation>(user, null, HttpStatus.OK);

	}

	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	ResponseEntity<Set<UserAuthorisation>> getAllUsers() {
		log.debug("********** Retriving all Amenities ****************");
		final Set<UserAuthorisation> users = this.userService.getAllAuthorisedUsers();
		return new ResponseEntity<Set<UserAuthorisation>>(users, null, HttpStatus.OK);

	}

	@RequestMapping(value = "/authenticateUser/{userName}/{passWord}", method = RequestMethod.GET)
	ResponseEntity<String> authenticateUser(@PathVariable final String userName, @PathVariable final String passWord) {
		log.debug("********** Authenticate user ****************");
		final String isValid = this.userService.getAuthorisedUserByNameAndPassword(userName, passWord);
		return new ResponseEntity<String>(isValid, null, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/CreateUser", method = RequestMethod.POST)
	public @ResponseBody String createUser(@RequestBody UserAuthorisation user) {
		log.debug("********** Create user ****************");
		final String userCreated = this.userService.createUser(user);
		return userCreated;
	}

}
