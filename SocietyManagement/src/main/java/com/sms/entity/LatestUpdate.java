package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tbl_sms_latest_updates database table.
 * 
 */
@Entity
@Table(name="tbl_sms_latest_updates")
@NamedQuery(name="LatestUpdate.findAll", query="SELECT l FROM LatestUpdate l")
public class LatestUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sms_update_id")
	private int smsUpdateId;

	private byte active;

	@Column(name="column_1")
	private String column1;

	@Column(name="column_2")
	private String column2;

	@Column(name="column_3")
	private String column3;

	@Column(name="column_4")
	private String column4;

	@Column(name="column_5")
	private String column5;

	@Column(name="event_file_name")
	private String eventFileName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="event_from")
	private Date eventFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="event_to")
	private Date eventTo;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="last_updated_by_user_info_id")
	private int lastUpdatedByUserInfoId;

	@Column(name="update_desc")
	private String updateDesc;

	private int version;

	public LatestUpdate() {
	}

	public int getSmsUpdateId() {
		return this.smsUpdateId;
	}

	public void setSmsUpdateId(int smsUpdateId) {
		this.smsUpdateId = smsUpdateId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return this.column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getColumn3() {
		return this.column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	public String getColumn4() {
		return this.column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	public String getColumn5() {
		return this.column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}

	public String getEventFileName() {
		return this.eventFileName;
	}

	public void setEventFileName(String eventFileName) {
		this.eventFileName = eventFileName;
	}

	public Date getEventFrom() {
		return this.eventFrom;
	}

	public void setEventFrom(Date eventFrom) {
		this.eventFrom = eventFrom;
	}

	public Date getEventTo() {
		return this.eventTo;
	}

	public void setEventTo(Date eventTo) {
		this.eventTo = eventTo;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getLastUpdatedByUserInfoId() {
		return this.lastUpdatedByUserInfoId;
	}

	public void setLastUpdatedByUserInfoId(int lastUpdatedByUserInfoId) {
		this.lastUpdatedByUserInfoId = lastUpdatedByUserInfoId;
	}

	public String getUpdateDesc() {
		return this.updateDesc;
	}

	public void setUpdateDesc(String updateDesc) {
		this.updateDesc = updateDesc;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}