package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tbl_sms_amenities database table.
 *
 */
@Entity
@Table(name = "tbl_sms_amenities")
@NamedQuery(name = "Amenity.findAll", query = "SELECT a FROM Amenity a")
public class Amenity extends AEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "amenity_id")
	private int amenityId;

	private byte active;

	@Column(name = "amenity_name")
	private String amenityName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_date")
	private Date lastUpdateDate;

	private int version;

	public int getAmenityId() {
		return this.amenityId;
	}

	public void setAmenityId(final int amenityId) {
		this.amenityId = amenityId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(final byte active) {
		this.active = active;
	}

	public String getAmenityName() {
		return this.amenityName;
	}

	public void setAmenityName(final String amenityName) {
		this.amenityName = amenityName;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(final Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

}