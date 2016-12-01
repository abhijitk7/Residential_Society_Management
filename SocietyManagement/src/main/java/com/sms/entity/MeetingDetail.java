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
 * The persistent class for the tbl_sms_meeting_details database table.
 * 
 */
@Entity
@Table(name="tbl_sms_meeting_details")
@NamedQuery(name="MeetingDetail.findAll", query="SELECT m FROM MeetingDetail m")
public class MeetingDetail extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="meeting_id")
	private int meetingId;

	private byte active;

	private String agenda;

	private String column1;

	private String column2;

	private String column3;

	private String column4;

	@Column(name="invite_all")
	private byte inviteAll;

	@Column(name="invite_board")
	private byte inviteBoard;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update_date")
	private Date lastUpdateDate;

	@Column(name="last_updated_by")
	private int lastUpdatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="meeting_date")
	private Date meetingDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="meeting_from")
	private Date meetingFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="meeting_to")
	private Date meetingTo;

	@Column(name="mom_file_name")
	private String momFileName;

	private int version;

	public MeetingDetail() {
	}

	public int getMeetingId() {
		return this.meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getAgenda() {
		return this.agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
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

	public byte getInviteAll() {
		return this.inviteAll;
	}

	public void setInviteAll(byte inviteAll) {
		this.inviteAll = inviteAll;
	}

	public byte getInviteBoard() {
		return this.inviteBoard;
	}

	public void setInviteBoard(byte inviteBoard) {
		this.inviteBoard = inviteBoard;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getMeetingDate() {
		return this.meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getMeetingFrom() {
		return this.meetingFrom;
	}

	public void setMeetingFrom(Date meetingFrom) {
		this.meetingFrom = meetingFrom;
	}

	public Date getMeetingTo() {
		return this.meetingTo;
	}

	public void setMeetingTo(Date meetingTo) {
		this.meetingTo = meetingTo;
	}

	public String getMomFileName() {
		return this.momFileName;
	}

	public void setMomFileName(String momFileName) {
		this.momFileName = momFileName;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}