package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tbl_sms_opinion_details database table.
 * 
 */
@Entity
@Table(name="tbl_sms_opinion_details")
@NamedQuery(name="OpinionDetail.findAll", query="SELECT o FROM OpinionDetail o")
public class OpinionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opinion_poll_id")
	private int opinionPollId;

	private byte active;

	@Column(name="column_1")
	private String column1;

	@Column(name="column_2")
	private String column2;

	@Column(name="column_3")
	private String column3;

	@Column(name="created_by_user_info_id")
	private int createdByUserInfoId;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="opinion_poll_question")
	private String opinionPollQuestion;

	@Column(name="option_a")
	private String optionA;

	@Column(name="option_b")
	private String optionB;

	@Column(name="option_c")
	private String optionC;

	@Column(name="option_d")
	private String optionD;

	@Column(name="option_e")
	private String optionE;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="poll_end_date")
	private Date pollEndDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="poll_start_date")
	private Date pollStartDate;

	private int version;

	public OpinionDetail() {
	}

	public int getOpinionPollId() {
		return this.opinionPollId;
	}

	public void setOpinionPollId(int opinionPollId) {
		this.opinionPollId = opinionPollId;
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

	public int getCreatedByUserInfoId() {
		return this.createdByUserInfoId;
	}

	public void setCreatedByUserInfoId(int createdByUserInfoId) {
		this.createdByUserInfoId = createdByUserInfoId;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getOpinionPollQuestion() {
		return this.opinionPollQuestion;
	}

	public void setOpinionPollQuestion(String opinionPollQuestion) {
		this.opinionPollQuestion = opinionPollQuestion;
	}

	public String getOptionA() {
		return this.optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return this.optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return this.optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return this.optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getOptionE() {
		return this.optionE;
	}

	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}

	public Date getPollEndDate() {
		return this.pollEndDate;
	}

	public void setPollEndDate(Date pollEndDate) {
		this.pollEndDate = pollEndDate;
	}

	public Date getPollStartDate() {
		return this.pollStartDate;
	}

	public void setPollStartDate(Date pollStartDate) {
		this.pollStartDate = pollStartDate;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}