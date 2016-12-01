/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0 The persistent class for the tbl_sms_user_auth database table.
 *
 */
@Entity
@Table(name = "tbl_sms_user_auth")
@NamedQueries({ @NamedQuery(name = "UserAuthorisation.findAll", query = "SELECT u FROM UserAuthorisation u"),
	@NamedQuery(name = "UserAuthorisation.findById", query = "SELECT u FROM UserAuthorisation u Where u.userId=:userId") })
public class UserAuthorisation extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "active")
	private byte active;

	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	@Column(name = "password")
	private String passWord;

	@Column(name = "role_id")
	private int roleId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "version")
	private int version;

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(final int userId) {
		this.userId = userId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(final byte active) {
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

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(final int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

}