package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_sms_amenities database table.
 * 
 */
@Entity
@Table(name="tbl_sms_amenities")
@NamedQuery(name="Amenity.findAll", query="SELECT a FROM Amenity a")
public class Amenity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="amenity_id")
	private int amenityId;

	private byte active;

	@Column(name="amenity_name")
	private String amenityName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update_date")
	private Date lastUpdateDate;

	private int version;

	//bi-directional many-to-one association to AmenitiesBooking
	@OneToMany(mappedBy="tblSmsAmenity")
	private List<AmenitiesBooking> tblSmsAmenitiesBookings;

	public Amenity() {
	}

	public int getAmenityId() {
		return this.amenityId;
	}

	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getAmenityName() {
		return this.amenityName;
	}

	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<AmenitiesBooking> getTblSmsAmenitiesBookings() {
		return this.tblSmsAmenitiesBookings;
	}

	public void setTblSmsAmenitiesBookings(List<AmenitiesBooking> tblSmsAmenitiesBookings) {
		this.tblSmsAmenitiesBookings = tblSmsAmenitiesBookings;
	}

	public AmenitiesBooking addTblSmsAmenitiesBooking(AmenitiesBooking tblSmsAmenitiesBooking) {
		getTblSmsAmenitiesBookings().add(tblSmsAmenitiesBooking);
		tblSmsAmenitiesBooking.setTblSmsAmenity(this);

		return tblSmsAmenitiesBooking;
	}

	public AmenitiesBooking removeTblSmsAmenitiesBooking(AmenitiesBooking tblSmsAmenitiesBooking) {
		getTblSmsAmenitiesBookings().remove(tblSmsAmenitiesBooking);
		tblSmsAmenitiesBooking.setTblSmsAmenity(null);

		return tblSmsAmenitiesBooking;
	}

}