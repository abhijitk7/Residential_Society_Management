/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sms.util.SystemConstants;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0 The persistent class for the tbl_sms_user_auth database table.
 *
 */
@Entity
@Table(name = "tbl_sms_users")
@NamedQueries({ @NamedQuery(name = "UserAuthorisation.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "UserAuthorisation.findById", query = "SELECT u FROM User u Where u.userId=:userId") })
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "active")
	private Boolean active=true;

	//This will be updated as last log on date also
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern=SystemConstants.JAVASCRIPT_DATE_FORMAT)
	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	@Column(name = "password")
	private String passWord;


	@Column(name = "user_name")
	private String userName;

	@Column(name = "version")
	private Long version=0L;
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
    @JoinColumn(name = "user_ID", nullable=false,updatable=true)
	private Set<UserRoles> roles;
	
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="user_info_id",nullable=false)
	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(final Boolean active) {
		this.active = active;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(final Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassword(final String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(final Long version) {
		this.version = version;
	}

}