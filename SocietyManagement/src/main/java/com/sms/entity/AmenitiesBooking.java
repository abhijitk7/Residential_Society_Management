package com.sms.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	private int amenityBookingId;

	private byte active;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="from_datetime")
	private Date fromDatetime;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="requested_by_user_info_id")
	private int requestedByUserInfoId;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="to_datetime")
	private Date toDatetime;

	private int version;

	//bi-directional many-to-one association to Amenity
	@ManyToOne
	@JoinColumn(name="amenity_id")
	private Amenity tblSmsAmenity;

	public AmenitiesBooking() {
	}

	public int getAmenityBookingId() {
		return this.amenityBookingId;
	}

	public void setAmenityBookingId(int amenityBookingId) {
		this.amenityBookingId = amenityBookingId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFromDatetime() {
		return this.fromDatetime;
	}

	public void setFromDatetime(Date fromDatetime) {
		this.fromDatetime = fromDatetime;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getRequestedByUserInfoId() {
		return this.requestedByUserInfoId;
	}

	public void setRequestedByUserInfoId(int requestedByUserInfoId) {
		this.requestedByUserInfoId = requestedByUserInfoId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getToDatetime() {
		return this.toDatetime;
	}

	public void setToDatetime(Date toDatetime) {
		this.toDatetime = toDatetime;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Amenity getTblSmsAmenity() {
		return this.tblSmsAmenity;
	}

	public void setTblSmsAmenity(Amenity tblSmsAmenity) {
		this.tblSmsAmenity = tblSmsAmenity;
	}

}