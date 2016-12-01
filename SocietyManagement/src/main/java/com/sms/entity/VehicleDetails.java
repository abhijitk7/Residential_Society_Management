package com.sms.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tbl_sms_vehicle_details database table.
 * 
 */
@Entity
@Table(name="tbl_sms_vehicle_details")
@NamedQuery(name="VehicleDetails.findAll", query="SELECT v FROM VehicleDetails v")
public class VehicleDetails extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_details_id")
	private int vehicleDetailsId;

	private byte active;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="rto_rc_id")
	private String rtoRcId;

	@Column(name="vehicle_desc")
	private String vehicleDesc;

	@Column(name="vehicle_number")
	private String vehicleNumber;

	@Column(name="vehicle_type")
	private String vehicleType;

	private int version;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="vehicle_owner_user_info_id")
	private UserInfo UserInfo;

	public VehicleDetails() {
	}

	public int getVehicleDetailsId() {
		return this.vehicleDetailsId;
	}

	public void setVehicleDetailsId(int vehicleDetailsId) {
		this.vehicleDetailsId = vehicleDetailsId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getRtoRcId() {
		return this.rtoRcId;
	}

	public void setRtoRcId(String rtoRcId) {
		this.rtoRcId = rtoRcId;
	}

	public String getVehicleDesc() {
		return this.vehicleDesc;
	}

	public void setVehicleDesc(String vehicleDesc) {
		this.vehicleDesc = vehicleDesc;
	}

	public String getVehicleNumber() {
		return this.vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public UserInfo getUserInfo() {
		return this.UserInfo;
	}

	public void setUserInfo(UserInfo UserInfo) {
		this.UserInfo = UserInfo;
	}

}