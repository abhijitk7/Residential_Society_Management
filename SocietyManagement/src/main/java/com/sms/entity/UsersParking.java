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

@Entity
@Table(name = "tbl_sms_users_parking")
public class UsersParking extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6181383304326936710L;

	@Id
	@Column(name="users_parking_id")
	private Long usersParkingId;
	
	@Column(name="user_info_id")
	private Long userInfoId;
	
	@Column(name="parking_slot_id")
	private Long parkingSlotId;
	
	@Column(name="active")
	private Boolean active=true;
	
	@Column(name = "last_updated_date")
	private Date lastUpdateDate;
	
	@Column(name="last_updated_by")
	private Long lastUpdatedBy;

	public Long getUsersParkingId() {
		return usersParkingId;
	}

	public void setUsersParkingId(Long usersParkingId) {
		this.usersParkingId = usersParkingId;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Long getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(Long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
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
