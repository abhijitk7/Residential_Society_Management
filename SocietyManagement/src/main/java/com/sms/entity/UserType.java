package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_sms_user_type database table.
 * 
 */
@Entity
@Table(name="tbl_sms_user_type")
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_type_id")
	private int userTypeId;

	private byte active;

	@Column(name="user_type_name")
	private String userTypeName;

	private int version;

	public UserType() {
	}

	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}