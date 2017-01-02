/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Abhijit A. Kulkarni
 * @Crated on Dec 21, 2016
 * The persistent class for the tbl_sms_user_info database table.
 * 
 */
@Entity
@Table(name="tbl_sms_user_info")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_info_id")
	private Long userInfoId;

	@Column(name="active")
	private Boolean active;

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
	private Boolean isBoardMember;

	@Column(name="is_secondary_owner")
	private Boolean isSecondaryOwner;

	@Column(name="is_valid")
	private Boolean isValid;

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

	@Lob
	@Column(name="user_image")
	private byte[] userImage;

	@Column(name="user_type_id")
	private Long userTypeId;

	@Column(name="version")
	private Long version;

	//bi-directional many-to-one association to VehicleDetails
	@OneToMany(mappedBy="UserInfo")
	private List<VehicleDetails> VehicleDetails;
	
	public Long getUserInfoId() {
		return this.userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
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

	public Boolean getIsBoardMember() {
		return this.isBoardMember;
	}

	public void setIsBoardMember(Boolean isBoardMember) {
		this.isBoardMember = isBoardMember;
	}

	public Boolean getIsSecondaryOwner() {
		return this.isSecondaryOwner;
	}

	public void setIsSecondaryOwner(Boolean isSecondaryOwner) {
		this.isSecondaryOwner = isSecondaryOwner;
	}

	public Boolean getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Boolean isValid) {
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

	
	public byte[] getUserImage() {
		return this.userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public Long getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
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