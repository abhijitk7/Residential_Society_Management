package com.sms.dto;

import java.math.BigDecimal;


public class UserInfoDTO {
	
	private Long userInfoId;
	
	private String emailId;
	
	private String alterEmailId;

	private String flatNumber;

	private Boolean isBoardMember;

	private Boolean isSecondaryOwner;

	private String primFirstName;

	private String primLastName;

	private String primMiddleName;

	private String parkingSlots;

	private BigDecimal primaryM1;

	private String secFirstName;

	private String secLastName;

	private String secMiddleName;

	private BigDecimal secondaryM2;

	private String correspondanceAddress;

	public String getCorrespondanceAddress() {
		return correspondanceAddress;
	}

	public void setCorrespondanceAddress(String correspondanceAddress) {
		this.correspondanceAddress = correspondanceAddress;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAlterEmailId() {
		return alterEmailId;
	}

	public void setAlterEmailId(String alterEmailId) {
		this.alterEmailId = alterEmailId;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public Boolean getIsBoardMember() {
		return isBoardMember;
	}

	public void setIsBoardMember(Boolean isBoardMember) {
		this.isBoardMember = isBoardMember;
	}

	public Boolean getIsSecondaryOwner() {
		return isSecondaryOwner;
	}

	public void setIsSecondaryOwner(Boolean isSecondaryOwner) {
		this.isSecondaryOwner = isSecondaryOwner;
	}

	public String getPrimFirstName() {
		return primFirstName;
	}

	public void setPrimFirstName(String primFirstName) {
		this.primFirstName = primFirstName;
	}

	public String getPrimLastName() {
		return primLastName;
	}

	public void setPrimLastName(String primLastName) {
		this.primLastName = primLastName;
	}

	public String getPrimMiddleName() {
		return primMiddleName;
	}

	public void setPrimMiddleName(String primMiddleName) {
		this.primMiddleName = primMiddleName;
	}

	public String getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(String parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public BigDecimal getPrimaryM1() {
		return primaryM1;
	}

	public void setPrimaryM1(BigDecimal primaryM1) {
		this.primaryM1 = primaryM1;
	}

	public String getSecFirstName() {
		return secFirstName;
	}

	public void setSecFirstName(String secFirstName) {
		this.secFirstName = secFirstName;
	}

	public String getSecLastName() {
		return secLastName;
	}

	public void setSecLastName(String secLastName) {
		this.secLastName = secLastName;
	}

	public String getSecMiddleName() {
		return secMiddleName;
	}

	public void setSecMiddleName(String secMiddleName) {
		this.secMiddleName = secMiddleName;
	}

	public BigDecimal getSecondaryM2() {
		return secondaryM2;
	}

	public void setSecondaryM2(BigDecimal secondaryM2) {
		this.secondaryM2 = secondaryM2;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	

}
