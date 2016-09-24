package com.sms.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tbl_sms_user_info database table.
 * 
 */
@Entity
@Table(name="tbl_sms_user_info")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_info_id")
	private int userInfoId;

	private byte active;

	private String col_1;

	private String col_2;

	private String col_3;

	private String col_4;

	private String col_5;

	@Column(name="correspondance_address")
	private String correspondanceAddress;

	@Column(name="email_id")
	private String emailId;

	@Column(name="flat_number")
	private String flatNumber;

	@Column(name="is_board_member")
	private byte isBoardMember;

	@Column(name="is_secondary_owner")
	private byte isSecondaryOwner;

	@Column(name="is_valid")
	private byte isValid;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="p_first_name")
	private String pFirstName;

	@Column(name="p_last_name")
	private String pLastName;

	@Column(name="p_middle_name")
	private String pMiddleName;

	@Column(name="parking_slots")
	private String parkingSlots;

	@Column(name="primary_m1")
	private BigDecimal primaryM1;

	@Column(name="s_first_name")
	private String sFirstName;

	@Column(name="s_last_name")
	private String sLastName;

	@Column(name="s_middle_name")
	private String sMiddleName;

	@Column(name="secondary_m2")
	private BigDecimal secondaryM2;

	@Column(name="user_id")
	private int userId;

	@Lob
	@Column(name="user_image")
	private byte[] userImage;

	@Column(name="user_type_id")
	private int userTypeId;

	private int version;

	//bi-directional many-to-one association to VehicleDetails
	@OneToMany(mappedBy="UserInfo")
	private List<VehicleDetails> VehicleDetails;
	
	//bi-directional many-to-one association to SmsLatestUpdate
	@OneToMany(mappedBy="tblSmsUserInfo")
	private List<SmsLatestUpdate> tblSmsLatestUpdates;

	//bi-directional many-to-one association to SmsOpinionDetail
	@OneToMany(mappedBy="tblSmsUserInfo")
	private List<SmsOpinionDetail> tblSmsOpinionDetails;

	public UserInfo() {
	}

	public int getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getCol_1() {
		return this.col_1;
	}

	public void setCol_1(String col_1) {
		this.col_1 = col_1;
	}

	public String getCol_2() {
		return this.col_2;
	}

	public void setCol_2(String col_2) {
		this.col_2 = col_2;
	}

	public String getCol_3() {
		return this.col_3;
	}

	public void setCol_3(String col_3) {
		this.col_3 = col_3;
	}

	public String getCol_4() {
		return this.col_4;
	}

	public void setCol_4(String col_4) {
		this.col_4 = col_4;
	}

	public String getCol_5() {
		return this.col_5;
	}

	public void setCol_5(String col_5) {
		this.col_5 = col_5;
	}

	public String getCorrespondanceAddress() {
		return this.correspondanceAddress;
	}

	public void setCorrespondanceAddress(String correspondanceAddress) {
		this.correspondanceAddress = correspondanceAddress;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFlatNumber() {
		return this.flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public byte getIsBoardMember() {
		return this.isBoardMember;
	}

	public void setIsBoardMember(byte isBoardMember) {
		this.isBoardMember = isBoardMember;
	}

	public byte getIsSecondaryOwner() {
		return this.isSecondaryOwner;
	}

	public void setIsSecondaryOwner(byte isSecondaryOwner) {
		this.isSecondaryOwner = isSecondaryOwner;
	}

	public byte getIsValid() {
		return this.isValid;
	}

	public void setIsValid(byte isValid) {
		this.isValid = isValid;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPFirstName() {
		return this.pFirstName;
	}

	public void setPFirstName(String pFirstName) {
		this.pFirstName = pFirstName;
	}

	public String getPLastName() {
		return this.pLastName;
	}

	public void setPLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public String getPMiddleName() {
		return this.pMiddleName;
	}

	public void setPMiddleName(String pMiddleName) {
		this.pMiddleName = pMiddleName;
	}

	public String getParkingSlots() {
		return this.parkingSlots;
	}

	public void setParkingSlots(String parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public BigDecimal getPrimaryM1() {
		return this.primaryM1;
	}

	public void setPrimaryM1(BigDecimal primaryM1) {
		this.primaryM1 = primaryM1;
	}

	public String getSFirstName() {
		return this.sFirstName;
	}

	public void setSFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getSLastName() {
		return this.sLastName;
	}

	public void setSLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getSMiddleName() {
		return this.sMiddleName;
	}

	public void setSMiddleName(String sMiddleName) {
		this.sMiddleName = sMiddleName;
	}

	public BigDecimal getSecondaryM2() {
		return this.secondaryM2;
	}

	public void setSecondaryM2(BigDecimal secondaryM2) {
		this.secondaryM2 = secondaryM2;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public byte[] getUserImage() {
		return this.userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<VehicleDetails> getVehicleDetails() {
		return this.VehicleDetails;
	}

	public void setVehicleDetails(List<VehicleDetails> VehicleDetails) {
		this.VehicleDetails = VehicleDetails;
	}

	public VehicleDetails addVehicleDetail(VehicleDetails VehicleDetail) {
		getVehicleDetails().add(VehicleDetail);
		VehicleDetail.setUserInfo(this);

		return VehicleDetail;
	}

	public VehicleDetails removeVehicleDetail(VehicleDetails VehicleDetail) {
		getVehicleDetails().remove(VehicleDetail);
		VehicleDetail.setUserInfo(null);

		return VehicleDetail;
	}

}