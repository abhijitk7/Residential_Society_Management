package com.sms.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tbl_sms_expenditure_details database table.
 * 
 */
@Entity
@Table(name="tbl_sms_expenditure_details")
@NamedQuery(name="ExpenditureDetail.findAll", query="SELECT e FROM ExpenditureDetail e")
public class ExpenditureDetail extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="expenditure_id")
	private int expenditureId;

	private byte active;

	@Column(name="actual_amount_spent")
	private int actualAmountSpent;

	@Column(name="column_1")
	private String column1;

	@Column(name="column_2")
	private String column2;

	@Column(name="column_3")
	private String column3;

	@Column(name="expense_description")
	private String expenseDescription;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invoice_date")
	private Date invoiceDate;

	@Column(name="invoice_file")
	private String invoiceFile;

	@Column(name="invoice_number")
	private int invoiceNumber;

	@Column(name="last_update_date")
	private Timestamp lastUpdateDate;

	@Column(name="update_by_user_info_id")
	private int updateByUserInfoId;

	private int version;

	//bi-directional many-to-one association to ExpenseRequest
	@ManyToOne
	@JoinColumn(name="expense_request_id")
	private ExpenseRequest tblSmsExpenseRequest;

	public ExpenditureDetail() {
	}

	public int getExpenditureId() {
		return this.expenditureId;
	}

	public void setExpenditureId(int expenditureId) {
		this.expenditureId = expenditureId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public int getActualAmountSpent() {
		return this.actualAmountSpent;
	}

	public void setActualAmountSpent(int actualAmountSpent) {
		this.actualAmountSpent = actualAmountSpent;
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

	public String getExpenseDescription() {
		return this.expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceFile() {
		return this.invoiceFile;
	}

	public void setInvoiceFile(String invoiceFile) {
		this.invoiceFile = invoiceFile;
	}

	public int getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Timestamp getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getUpdateByUserInfoId() {
		return this.updateByUserInfoId;
	}

	public void setUpdateByUserInfoId(int updateByUserInfoId) {
		this.updateByUserInfoId = updateByUserInfoId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public ExpenseRequest getTblSmsExpenseRequest() {
		return this.tblSmsExpenseRequest;
	}

	public void setTblSmsExpenseRequest(ExpenseRequest tblSmsExpenseRequest) {
		this.tblSmsExpenseRequest = tblSmsExpenseRequest;
	}

}