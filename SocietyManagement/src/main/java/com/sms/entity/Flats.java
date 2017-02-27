/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0 
 * The persistent class for the tbl_sms_user_auth database table.
 */
@Entity
@Table(name = "tbl_sms_flat_list")
public class Flats extends AbstractEntity {

	private static final long serialVersionUID = -1529884043023471546L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flat_id")
	private Long flatId;
	
	@Column(name = "flat_name")
	private String flatName;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "last_updated_by")
	private Long lastUpdatedBy;
	
	@Column(name = "last_update_date")
	private Date lastUpdateDate;
	
	/**
	 * Zero argument constructor for JPA
	 */
	public Flats() {
		super();
	}
	
	/**
	 * @param flatId
	 * @param flatName
	 * @param active
	 * @param lastUpdatedBy
	 * @param lastUpdateDate
	 */
	public Flats(Long flatId, String flatName, Boolean active, Long lastUpdatedBy, Date lastUpdateDate) {
		super();
		this.flatId = flatId;
		this.flatName = flatName;
		this.active = active;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the flatId
	 */
	public Long getFlatId() {
		return flatId;
	}

	/**
	 * @param flatId the flatId to set
	 */
	public void setFlatId(Long flatId) {
		this.flatId = flatId;
	}

	/**
	 * @return the flatName
	 */
	public String getFlatName() {
		return flatName;
	}

	/**
	 * @param flatName the flatName to set
	 */
	public void setFlatName(String flatName) {
		this.flatName = flatName;
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
	 * @return the lastUpdatedBy
	 */
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	
}
