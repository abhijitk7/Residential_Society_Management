/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.security;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sms.dao.IRoleJpaDao;
import com.sms.dao.IUserJpaDao;
import com.sms.entity.User;
import com.sms.entity.UserRoles;

/**
 * @author Abhijit Kulkarni
 * @since 25 Dec 2016
 * @version 1.0
 */

@Service("authenticationUserDetailsService")
public class AuthenticationUserDetailsService implements UserDetailsService {

    private static final String MAGIC_KEY = "SmsAppKey-right_here";


    @Autowired(required = true)
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;
    
    @Autowired
	private IUserJpaDao userAuthDao;
    
    @Autowired
	private IRoleJpaDao roleJpaDao;


	@Override
	public UserDetails loadUserByUsername(String userName) {
	
	    User user = userAuthDao.getAuthorisedUserByName(userName);
	
	    if (user == null) {
	        return null;
	    }
	
	    org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
	    		userName, user.getPassWord(), getGrantedAuthorities(user));
	
	        return userDetails;
	    }
	
	public User getUserDetails(String userName){
		
		User user = userAuthDao.getAuthorisedUserByName(userName);
		
	    if (user == null) {
	        return null;
	    }
	    
	    return user;
	}

    public String createToken(UserDetails userDetails) {

        // Expires in one hour
        long expires = System.currentTimeMillis() + 1000L * 60 * 60;

        StringBuilder tokenBuilder = new StringBuilder();
        tokenBuilder.append(userDetails.getUsername());
        tokenBuilder.append(":");
        tokenBuilder.append(expires);
        tokenBuilder.append(":");
        tokenBuilder.append(createEncryptedSignature(userDetails, expires));

        return tokenBuilder.toString();
    }

    public String getUserNameFromToken(String authToken) {

        if (null == authToken) {
            return null;
        }

        String[] parts = authToken.split(":");
        return parts[0];
    }

    public boolean validateToken(String authToken, UserDetails userDetails) {

        String[] parts = authToken.split(":");
        long expires = Long.parseLong(parts[1]);
        String encryptedSignature = parts[2];

        if (expires < System.currentTimeMillis()) {
            return false;
        }

        String rawSignature = createRawSignature(userDetails, expires);
        boolean isValid = passwordEncoder.matches(rawSignature, encryptedSignature);
        return isValid;
    }

    private String createEncryptedSignature(UserDetails userDetails, long expires) {

        String rawSignature = createRawSignature(userDetails, expires);

        return passwordEncoder.encode(rawSignature);
    }

    private String createRawSignature(UserDetails userDetails, long expires) {

        StringBuilder signatureBuilder = new StringBuilder();
        signatureBuilder.append(userDetails.getUsername());
        signatureBuilder.append(":");
        signatureBuilder.append(expires);
        signatureBuilder.append(":");
        signatureBuilder.append(AuthenticationUserDetailsService.MAGIC_KEY);

        return signatureBuilder.toString();
    }

    public Collection<? extends GrantedAuthority> getGrantedAuthorities(User user) {

        Set<UserRoles> roles = user.getRoles();
        
        Set<Long> roleIds=new HashSet<Long>();
        
        for(UserRoles role:roles){
        	roleIds.add(role.getRoleId());
        }
        
        List<String> roleList=roleJpaDao.getRolesByIds(roleIds);

        if (roleList == null) {
            return Collections.emptyList();
        }

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (String role : roleList) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}
