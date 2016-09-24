package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_sms_role database table.
 * 
 */
@Entity
@Table(name="tbl_sms_role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	private byte active;

	@Column(name="role_name")
	private String roleName;

	private int version;

	//bi-directional many-to-one association to UserAuthorisation
	@OneToMany(mappedBy="tblSmsRole")
	private List<UserAuthorisation> tblSmsUserAuths;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<UserAuthorisation> getTblSmsUserAuths() {
		return this.tblSmsUserAuths;
	}

	public void setTblSmsUserAuths(List<UserAuthorisation> tblSmsUserAuths) {
		this.tblSmsUserAuths = tblSmsUserAuths;
	}

	public UserAuthorisation addTblSmsUserAuth(UserAuthorisation tblSmsUserAuth) {
		getTblSmsUserAuths().add(tblSmsUserAuth);
		tblSmsUserAuth.setTblSmsRole(this);

		return tblSmsUserAuth;
	}

	public UserAuthorisation removeTblSmsUserAuth(UserAuthorisation tblSmsUserAuth) {
		getTblSmsUserAuths().remove(tblSmsUserAuth);
		tblSmsUserAuth.setTblSmsRole(null);

		return tblSmsUserAuth;
	}

}