/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sms.entity.Amenity;
import com.sms.entity.BookingStatus;
import com.sms.util.SystemConstants;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on May 28, 2017
 * @Version 1.0
 */
public class UserBookingsDTO {
	
	private String comments;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern=SystemConstants.JAVASCRIPT_DATE_FORMAT)
	private Date fromDateTime;

	private BookingStatus status;

	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern=SystemConstants.JAVASCRIPT_DATE_FORMAT)
	private Date toDateTime;

	private Amenity amenity;

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the fromDatetime
	 */
	public Date getFromDateTime() {
		return fromDateTime;
	}

	/**
	 * @param fromDatetime the fromDatetime to set
	 */
	public void setFromDatetime(Date fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	/**
	 * @return the status
	 */
	public BookingStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	/**
	 * @return the toDateTime
	 */
	public Date getToDateTime() {
		return toDateTime;
	}

	/**
	 * @param toDatetime the toDateTime to set
	 */
	public void setToDatetime(Date toDateTime) {
		this.toDateTime = toDateTime;
	}

	/**
	 * @return the amenity
	 */
	public Amenity getAmenity() {
		return amenity;
	}

	/**
	 * @param amenity the amenity to set
	 */
	public void setAmenity(Amenity amenity) {
		this.amenity = amenity;
	}

}
