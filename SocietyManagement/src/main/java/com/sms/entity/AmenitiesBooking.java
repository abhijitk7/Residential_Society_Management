package com.sms.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * The persistent class for the tbl_sms_amenities_booking database table.
 * 
 */
@Entity
@Table(name="tbl_sms_amenities_booking")
@NamedQuery(name="AmenitiesBooking.findAll", query="SELECT a FROM AmenitiesBooking a")
public class AmenitiesBooking extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="amenity_booking_id")
	private Long amenityBookingId;

	@Column(name="active")
	private Boolean active;

	@Column(name="comments")
	private String comments;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="from_datetime")
	private Date fromDatetime;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;
	
	@OneToOne
	@JoinColumn(name="requested_by_user_info_id")
	private UserInfo requestedByUserInfoId;

	@OneToOne
	@JoinColumn(name="status")
	private BookingStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="to_datetime")
	private Date toDatetime;

	@Version
	private int version;

	@OneToOne
	@JoinColumn(name="amenity_id")
	private Amenity amenity;
	

	public AmenitiesBooking() {
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


	/**
	 * @return the amenityBookingId
	 */
	public Long getAmenityBookingId() {
		return amenityBookingId;
	}

	/**
	 * @param amenityBookingId the amenityBookingId to set
	 */
	public void setAmenityBookingId(Long amenityBookingId) {
		this.amenityBookingId = amenityBookingId;
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
	public Date getFromDatetime() {
		return fromDatetime;
	}

	/**
	 * @param fromDatetime the fromDatetime to set
	 */
	public void setFromDatetime(Date fromDatetime) {
		this.fromDatetime = fromDatetime;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the toDatetime
	 */
	public Date getToDatetime() {
		return toDatetime;
	}

	/**
	 * @param toDatetime the toDatetime to set
	 */
	public void setToDatetime(Date toDatetime) {
		this.toDatetime = toDatetime;
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
	 * @return the requestedByUserInfoId
	 */
	public UserInfo getRequestedByUserInfoId() {
		return requestedByUserInfoId;
	}

	/**
	 * @param requestedByUserInfoId the requestedByUserInfoId to set
	 */
	public void setRequestedByUserInfoId(UserInfo requestedByUserInfoId) {
		this.requestedByUserInfoId = requestedByUserInfoId;
	}


}