package com.sms.dto;

import java.math.BigDecimal;
import java.util.Set;

import com.sms.entity.Flats;
import com.sms.entity.ParkingSlots;


public class UserInfoDTO {
		
	private Long userInfoId;
	
	private String emailId;
	
	private String alterEmailId;

//	private String flatNumber;

	private Boolean isBoardMember;

	private Boolean isSecondaryOwner;

	private String primFirstName;

	private String primLastName;

	private String primMiddleName;

	//private String parkingSlots;

	private BigDecimal primaryM1;

	private String secFirstName;

	private String secLastName;

	private String secMiddleName;

	private BigDecimal secondaryM2;
	
	private String correspondanceAddress;
	
	private Set<Flats> usersFlats;
	
	private Set<ParkingSlots> usersParkings;
	
	private Long version;
	
	public UserInfoDTO(){
			
			
	}

	/**
	 * @param userInfoId
	 * @param emailId
	 * @param alterEmailId
	 * @param isBoardMember
	 * @param isSecondaryOwner
	 * @param primFirstName
	 * @param primLastName
	 * @param primMiddleName
	 * @param primaryM1
	 * @param secFirstName
	 * @param secLastName
	 * @param secMiddleName
	 * @param secondaryM2
	 * @param correspondanceAddress
	 * @param usersFlats
	 * @param usersParkings
	 */
	public UserInfoDTO(Long userInfoId, String emailId, String alterEmailId, Boolean isBoardMember,
			Boolean isSecondaryOwner, String primFirstName, String primLastName, String primMiddleName,
			BigDecimal primaryM1, String secFirstName, String secLastName, String secMiddleName, BigDecimal secondaryM2,
			String correspondanceAddress, Set<Flats> usersFlats, Set<ParkingSlots> usersParkings,Long version) {
		super();
		this.userInfoId = userInfoId;
		this.emailId = emailId;
		this.alterEmailId = alterEmailId;
		this.isBoardMember = isBoardMember;
		this.isSecondaryOwner = isSecondaryOwner;
		this.primFirstName = primFirstName;
		this.primLastName = primLastName;
		this.primMiddleName = primMiddleName;
		this.primaryM1 = primaryM1;
		this.secFirstName = secFirstName;
		this.secLastName = secLastName;
		this.secMiddleName = secMiddleName;
		this.secondaryM2 = secondaryM2;
		this.correspondanceAddress = correspondanceAddress;
		this.usersFlats = usersFlats;
		this.usersParkings = usersParkings;
		this.version=version;
	}


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

//	public String getFlatNumber() {
//		return flatNumber;
//	}
//
//	public void setFlatNumber(String flatNumber) {
//		this.flatNumber = flatNumber;
//	}

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

	public Set<Flats> getUsersFlats() {
		return usersFlats;
	}

	public void setUsersFlats(Set<Flats> usersFlats) {
		this.usersFlats = usersFlats;
	}

	/**
	 * @return the usersParkings
	 */
	public Set<ParkingSlots> getUsersParkings() {
		return usersParkings;
	}

	/**
	 * @param usersParkings the usersParkings to set
	 */
	public void setUsersParkings(Set<ParkingSlots> usersParkings) {
		this.usersParkings = usersParkings;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	

}
