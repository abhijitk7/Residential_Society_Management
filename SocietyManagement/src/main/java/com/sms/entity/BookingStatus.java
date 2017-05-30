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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Apr 14, 2017
 * @Version 1.0
 */
@Entity
@Table(name="tbl_sms_booking_status")
public class BookingStatus extends AbstractEntity {

	private static final long serialVersionUID = 5390695608296234714L;
	
	@Id
	@Column(name="booking_status_id")
	private Long bookingStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	@Version
	private int version;
	
	@Column(name = "active")
	private byte active;
	
	@Column(name = "booking_status")
	private String bookingStatus;

	/**
	 * @return the bookingStatusId
	 */
	public Long getBookingStatusId() {
		return bookingStatusId;
	}

	/**
	 * @param bookingStatusId the bookingStatusId to set
	 */
	public void setBookingStatusId(Long bookingStatusId) {
		this.bookingStatusId = bookingStatusId;
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
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the active
	 */
	public byte getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(byte active) {
		this.active = active;
	}

	/**
	 * @return the bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}

	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	

}
