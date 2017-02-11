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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_info_id")
	private Long userInfoId;
	

	@Column(name="active")
	private Boolean active=true;

	private String col_2;

	private String col_3;

	private String col_4;

	private String col_5;

	@Column(name="correspondance_address")
	private String correspondanceAddress;
	

	@Column(name="email_id")
	private String emailId;
	
	@Column(name="alter_email_id")
	private String alterEmailId;

	@Column(name="is_board_member")
	private Boolean isBoardMember=false;

	@Column(name="is_secondary_owner")
	private Boolean isSecondaryOwner;

	@Column(name="is_valid")
	private Boolean isValid;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="p_first_name")
	private String primFirstName;

	@Column(name="p_last_name")
	private String primLastName;

	@Column(name="p_middle_name")
	private String primMiddleName;

	@Column(name="primary_m1")
	private BigDecimal primaryM1;

	@Column(name="s_first_name")
	private String secFirstName;

	@Column(name="s_last_name")
	private String secLastName;

	@Column(name="s_middle_name")
	private String secMiddleName;

	@Column(name="secondary_m2")
	private BigDecimal secondaryM2;

	@Lob
	@Column(name="user_image")
	private byte[] userImage;

	@Column(name="user_type_id")
	private Long userTypeId;

	@Column(name="version")
	private Long version;
	
	@JsonIgnore
	@OneToOne(mappedBy = "userInfo")
	private User user;

//	//bi-directional many-to-one association to VehicleDetails
//	@OneToMany(mappedBy="UserInfo")
//	private List<VehicleDetails> vehicleDetails;
	
	@JsonIgnore
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name = "tbl_sms_users_flats", joinColumns=@JoinColumn(name="user_info_id",referencedColumnName="user_info_id"),inverseJoinColumns=@JoinColumn(name="flat_id",referencedColumnName="flat_id"))
	private Set<Flats> usersFlats=new HashSet<Flats>();
	
	@JsonIgnore
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
    @JoinTable(name="tbl_sms_users_parking",joinColumns=@JoinColumn(name="user_info_id",referencedColumnName="user_info_id"),inverseJoinColumns=@JoinColumn(name="parking_slot_id",referencedColumnName="parking_slot_id"))
	private Set<ParkingSlots> usersParkings=new HashSet<ParkingSlots>();
	
	public Set<ParkingSlots> getUsersParkings() {
		return usersParkings;
	}

	public void setUsersParkings(Set<ParkingSlots> usersParkings) {
		this.usersParkings = usersParkings;
	}

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

	public BigDecimal getPrimaryM1() {
		return this.primaryM1;
	}

	
	public void setPrimaryM1(BigDecimal primaryM1) {
		this.primaryM1 = primaryM1;
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

	
	public String getAlterEmailId() {
		return alterEmailId;
	}

	
	public void setAlterEmailId(String alterEmailId) {
		this.alterEmailId = alterEmailId;
	}
	
	public Set<Flats> getUsersFlats() {
		return usersFlats;
	}

	public void setUsersFlats(Set<Flats> usersFlats) {
		this.usersFlats = usersFlats;
	}

//	public List<UsersParking> getUsersParking() {
//		return usersParkings;
//	}
//
//	public void setUsersParking(List<UsersParking> usersParkings) {
//		this.usersParkings = usersParkings;
//	}
	

}