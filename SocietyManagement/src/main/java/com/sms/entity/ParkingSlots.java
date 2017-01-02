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
import javax.persistence.Table;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on JAN 02, 2017
 * @Version 1.0 The persistent class for the tbl_sms_user_auth database table.
 *
 */
@Entity
@Table(name="tbl_sms_parking_slots")
public class ParkingSlots extends AbstractEntity {

	private static final long serialVersionUID = 8756064068545462307L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parking_slot_id")
	private Long parkingSlotId;
	
	@Column(name = "parking_slot")
	private String parkingSlot;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "last_updated_by")
	private Boolean lastUpdatedBy;
	
	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	public Long getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(Long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}

	public String getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(String parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Boolean lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	

}
