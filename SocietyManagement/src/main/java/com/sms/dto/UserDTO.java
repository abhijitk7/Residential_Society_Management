/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dto;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sms.util.SystemConstants;

/**
 * @author Abhijit Kulkarni
 * @since 25 Dec 2016
 * @version 1.0
 */

public class UserDTO {

    private String userName;

    private Map<String, Boolean> roles;

    private String token;
    
    private Long userId;
    
    private Long userInfoId;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern=SystemConstants.JAVASCRIPT_DATE_FORMAT)
    private Date lastLogon;
    
    private String firstName;
    
    private String lastName;


    public UserDTO(String userName) {
        this.userName = userName;
    }


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the roles
	 */
	public Map<String, Boolean> getRoles() {
		return roles;
	}


	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Map<String, Boolean> roles) {
		this.roles = roles;
	}


	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}


	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}


	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	/**
	 * @return the userInfoId
	 */
	public Long getUserInfoId() {
		return userInfoId;
	}


	/**
	 * @param userInfoId the userInfoId to set
	 */
	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}


	/**
	 * @return the lastLogon
	 */
	public Date getLastLogon() {
		return lastLogon;
	}


	/**
	 * @param lastLogon the lastLogon to set
	 */
	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
