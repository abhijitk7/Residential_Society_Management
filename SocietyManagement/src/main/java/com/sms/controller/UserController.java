/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sms.entity.User;
import com.sms.exception.CustomGenericException;
import com.sms.security.AuthenticationUserDetailsService;
import com.sms.services.IUserService;
import com.sms.transfer.UserTransfer;

/**
 * @author Abhijit Kulkarni
 * @since 12 Nov 2016
 * @version 1.0
 */

@Controller
public class UserController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;
	
	@Autowired(required = true)
    private AuthenticationUserDetailsService userDetailsService;

    @Autowired(required = true)
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

	@RequestMapping(value = "/UserById/{userId}", method = RequestMethod.GET)
	ResponseEntity<User> getUserById(@PathVariable final String userId) {
		log.debug("********** Retriving all user by id ****************");
		final User user = this.userService.getAuthorisedUserById(Integer.parseInt(userId));
		return new ResponseEntity<User>(user, null, HttpStatus.OK);

	}

	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	ResponseEntity<Set<User>> getAllUsers() {
		log.debug("********** Retriving all Users ****************");
		final Set<User> users = this.userService.getAllAuthorisedUsers();
		return new ResponseEntity<Set<User>>(users, null, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/authenticateUser/{userName}/{passWord}",method=RequestMethod.POST)
    public ResponseEntity<UserTransfer> authenticate(@PathVariable final String userName, @PathVariable final String passWord) {

        UsernamePasswordAuthenticationToken authenticationToken
            = new UsernamePasswordAuthenticationToken(userName, passWord);

        Authentication authentication;

        try {
            authentication = authManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {

            throw new CustomGenericException(401, "The user name or password is incorrect");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        /*
         * Reload user as password of authentication principal will be null after authorization and
         * password is needed for token generation
         */
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        

        Map<String, Boolean> roles = createRolesMap(userDetails);
        String token = userDetailsService.createToken(userDetails);

        UserTransfer userTransfer = new UserTransfer(userDetails.getUsername());
        userTransfer.setRoles(roles);
        userTransfer.setToken(token);
        
        User user=userDetailsService.getUserDetails(userName);
        
        userTransfer.setUserId(user.getUserId());
        
        userTransfer.setLastLogon(user.getLastUpdateDate());
        
        userTransfer.setFirstName(user.getUserInfo().getPFirstName());
        
        userTransfer.setLastName(user.getUserInfo().getPLastName());

        return new ResponseEntity<UserTransfer>(userTransfer,HttpStatus.OK);
    }

    private Map<String, Boolean> createRolesMap(UserDetails userDetails) {
        Map<String, Boolean> roles = new HashMap<String, Boolean>();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.put(authority.getAuthority(), Boolean.TRUE);
        }

        return roles;
    }

    @RequestMapping(value = "/updateLastLogon/{userId}", method = RequestMethod.POST)
	public ResponseEntity<String> updateLastLogOn(@PathVariable Long userId) {
		log.debug("********** Create user ****************");
		final String userUpdated = this.userService.updateLastLogOn(userId);
		return new ResponseEntity<String>(userUpdated,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody String createUser(@RequestBody User user) {
		log.debug("********** Create user ****************");
		final String userCreated = this.userService.createUser(user);
		return userCreated;
	}
	
}
