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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Jan 23, 2017
 * @Version 1.0
 */
@Entity
@Table(name = "tbl_sms_users_flats")
public class UsersFlats extends AbstractEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6055363030258957226L;
	
	@Id
	@Column(name="user_flat_id")
	private Long userFlatId;
	
	@Column(name="user_info_id")
	private Long userInfoId;
	
	@Column(name="flat_id")
	private Long flatId;
	
	@Column(name="active")
	private Boolean active=true;
	
	@Column(name = "last_updated_date")
	private Date lastUpdateDate;
	
	@Column(name="last_updated_by")
	private Long lastUpdatedBy;

	public Long getUserFlatId() {
		return userFlatId;
	}

	public void setUserFlatId(Long userFlatId) {
		this.userFlatId = userFlatId;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Long getFlatId() {
		return flatId;
	}

	public void setFlatId(Long flatId) {
		this.flatId = flatId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	

}
