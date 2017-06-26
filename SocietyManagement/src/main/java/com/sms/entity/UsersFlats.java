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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Jan 23, 2017
 * @Version 1.0
 */
@Entity
@Table(name = "tbl_sms_users_flats")
public class UsersFlats extends AbstractEntity {

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
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="last_updated_by")
	private UserInfo lastUpdatedBy;

	/**
	 * @return the userFlatId
	 */
	public Long getUserFlatId() {
		return userFlatId;
	}

	/**
	 * @param userFlatId the userFlatId to set
	 */
	public void setUserFlatId(Long userFlatId) {
		this.userFlatId = userFlatId;
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
	 * @return the flatId
	 */
	public Long getFlatId() {
		return flatId;
	}

	/**
	 * @param flatId the flatId to set
	 */
	public void setFlatId(Long flatId) {
		this.flatId = flatId;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public UserInfo getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(UserInfo lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}
