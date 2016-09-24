package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_sms_expense_requests database table.
 * 
 */
@Entity
@Table(name="tbl_sms_expense_requests")
@NamedQuery(name="ExpenseRequest.findAll", query="SELECT e FROM ExpenseRequest e")
public class ExpenseRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="expense_request_id")
	private int expenseRequestId;

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

	@Column(name="expense_description")
	private String expenseDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expense_request_date")
	private Date expenseRequestDate;

	@Column(name="first_level_approval_comment")
	private String firstLevelApprovalComment;

	@Column(name="first_level_approval_status")
	private String firstLevelApprovalStatus;

	@Column(name="first_level_rejection_comment")
	private String firstLevelRejectionComment;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="raised_by_user_info_id")
	private int raisedByUserInfoId;

	@Column(name="second_level_approval_comment")
	private String secondLevelApprovalComment;

	@Column(name="second_level_approval_required")
	private byte secondLevelApprovalRequired;

	@Column(name="second_level_approval_status")
	private String secondLevelApprovalStatus;

	@Column(name="second_level_rejection_comment")
	private String secondLevelRejectionComment;

	@Column(name="tentative_expense_amount")
	private int tentativeExpenseAmount;

	private int version;

	//bi-directional many-to-one association to ExpenditureDetail
	@OneToMany(mappedBy="tblSmsExpenseRequest")
	private List<ExpenditureDetail> tblSmsExpenditureDetails;

	public ExpenseRequest() {
	}

	public int getExpenseRequestId() {
		return this.expenseRequestId;
	}

	public void setExpenseRequestId(int expenseRequestId) {
		this.expenseRequestId = expenseRequestId;
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

	public String getExpenseDescription() {
		return this.expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public Date getExpenseRequestDate() {
		return this.expenseRequestDate;
	}

	public void setExpenseRequestDate(Date expenseRequestDate) {
		this.expenseRequestDate = expenseRequestDate;
	}

	public String getFirstLevelApprovalComment() {
		return this.firstLevelApprovalComment;
	}

	public void setFirstLevelApprovalComment(String firstLevelApprovalComment) {
		this.firstLevelApprovalComment = firstLevelApprovalComment;
	}

	public String getFirstLevelApprovalStatus() {
		return this.firstLevelApprovalStatus;
	}

	public void setFirstLevelApprovalStatus(String firstLevelApprovalStatus) {
		this.firstLevelApprovalStatus = firstLevelApprovalStatus;
	}

	public String getFirstLevelRejectionComment() {
		return this.firstLevelRejectionComment;
	}

	public void setFirstLevelRejectionComment(String firstLevelRejectionComment) {
		this.firstLevelRejectionComment = firstLevelRejectionComment;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getRaisedByUserInfoId() {
		return this.raisedByUserInfoId;
	}

	public void setRaisedByUserInfoId(int raisedByUserInfoId) {
		this.raisedByUserInfoId = raisedByUserInfoId;
	}

	public String getSecondLevelApprovalComment() {
		return this.secondLevelApprovalComment;
	}

	public void setSecondLevelApprovalComment(String secondLevelApprovalComment) {
		this.secondLevelApprovalComment = secondLevelApprovalComment;
	}

	public byte getSecondLevelApprovalRequired() {
		return this.secondLevelApprovalRequired;
	}

	public void setSecondLevelApprovalRequired(byte secondLevelApprovalRequired) {
		this.secondLevelApprovalRequired = secondLevelApprovalRequired;
	}

	public String getSecondLevelApprovalStatus() {
		return this.secondLevelApprovalStatus;
	}

	public void setSecondLevelApprovalStatus(String secondLevelApprovalStatus) {
		this.secondLevelApprovalStatus = secondLevelApprovalStatus;
	}

	public String getSecondLevelRejectionComment() {
		return this.secondLevelRejectionComment;
	}

	public void setSecondLevelRejectionComment(String secondLevelRejectionComment) {
		this.secondLevelRejectionComment = secondLevelRejectionComment;
	}

	public int getTentativeExpenseAmount() {
		return this.tentativeExpenseAmount;
	}

	public void setTentativeExpenseAmount(int tentativeExpenseAmount) {
		this.tentativeExpenseAmount = tentativeExpenseAmount;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<ExpenditureDetail> getTblSmsExpenditureDetails() {
		return this.tblSmsExpenditureDetails;
	}

	public void setTblSmsExpenditureDetails(List<ExpenditureDetail> tblSmsExpenditureDetails) {
		this.tblSmsExpenditureDetails = tblSmsExpenditureDetails;
	}

	public ExpenditureDetail addTblSmsExpenditureDetail(ExpenditureDetail tblSmsExpenditureDetail) {
		getTblSmsExpenditureDetails().add(tblSmsExpenditureDetail);
		tblSmsExpenditureDetail.setTblSmsExpenseRequest(this);

		return tblSmsExpenditureDetail;
	}

	public ExpenditureDetail removeTblSmsExpenditureDetail(ExpenditureDetail tblSmsExpenditureDetail) {
		getTblSmsExpenditureDetails().remove(tblSmsExpenditureDetail);
		tblSmsExpenditureDetail.setTblSmsExpenseRequest(null);

		return tblSmsExpenditureDetail;
	}

}