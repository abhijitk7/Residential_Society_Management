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
    
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern=SystemConstants.JAVASCRIPT_DATE_FORMAT)
    private Date lastLogon;
    
    private String firstName;
    
    private String lastName;


    public UserDTO(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public Map<String, Boolean> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Boolean> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return userName + " [roles=" + roles + ", token=" + token + ']';
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Date getLastLogon() {
		return lastLogon;
	}

	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
