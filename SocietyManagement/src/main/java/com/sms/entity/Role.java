/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0 The persistent class for the tbl_sms_role database table.
 */
@Entity
@Table(name = "tbl_sms_role")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "active")
	private byte active;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "version")
	private int version;

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(final int roleId) {
		this.roleId = roleId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(final byte active) {
		this.active = active;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(final String roleName) {
		this.roleName = roleName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

}