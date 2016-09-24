package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tbl_sms_user_auth database table.
 * 
 */
@Entity
@Table(name="tbl_sms_user_auth")
@NamedQuery(name="UserAuthorisation.findAll", query="SELECT u FROM UserAuthorisation u")
public class UserAuthorisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private byte active;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	private String password;

	@Column(name="role_id")
	private int roleId;

	@Column(name="user_name")
	private String userName;

	private int version;

	//bi-directional many-to-one association to SmsUserInfo
	@OneToMany(mappedBy="tblSmsUserAuth")
	private List<SmsUserInfo> tblSmsUserInfos;

	public UserAuthorisation() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<SmsUserInfo> getTblSmsUserInfos() {
		return this.tblSmsUserInfos;
	}

	public void setTblSmsUserInfos(List<SmsUserInfo> tblSmsUserInfos) {
		this.tblSmsUserInfos = tblSmsUserInfos;
	}

	public SmsUserInfo addTblSmsUserInfo(SmsUserInfo tblSmsUserInfo) {
		getTblSmsUserInfos().add(tblSmsUserInfo);
		tblSmsUserInfo.setTblSmsUserAuth(this);

		return tblSmsUserInfo;
	}

	public SmsUserInfo removeTblSmsUserInfo(SmsUserInfo tblSmsUserInfo) {
		getTblSmsUserInfos().remove(tblSmsUserInfo);
		tblSmsUserInfo.setTblSmsUserAuth(null);

		return tblSmsUserInfo;
	}

}