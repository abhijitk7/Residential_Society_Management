package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the tbl_sms_user_payments database table.
 * 
 */
@Entity
@Table(name="tbl_sms_user_payments")
@NamedQuery(name="UserPayment.findAll", query="SELECT u FROM UserPayment u")
public class UserPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int paymentId;

	private byte active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="invoice_date")
	private Date invoiceDate;

	@Column(name="invoice_id")
	private String invoiceId;

	@Column(name="last_updated_by_user_info_id")
	private int lastUpdatedByUserInfoId;

	@Column(name="last_updated_date")
	private Timestamp lastUpdatedDate;

	@Column(name="payment_amount")
	private int paymentAmount;

	@Column(name="payment_by_user_info_id")
	private int paymentByUserInfoId;

	@Column(name="payment_desc")
	private String paymentDesc;

	@Column(name="payment_type_id")
	private String paymentTypeId;

	private int version;

	public UserPayment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getLastUpdatedByUserInfoId() {
		return this.lastUpdatedByUserInfoId;
	}

	public void setLastUpdatedByUserInfoId(int lastUpdatedByUserInfoId) {
		this.lastUpdatedByUserInfoId = lastUpdatedByUserInfoId;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public int getPaymentAmount() {
		return this.paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getPaymentByUserInfoId() {
		return this.paymentByUserInfoId;
	}

	public void setPaymentByUserInfoId(int paymentByUserInfoId) {
		this.paymentByUserInfoId = paymentByUserInfoId;
	}

	public String getPaymentDesc() {
		return this.paymentDesc;
	}

	public void setPaymentDesc(String paymentDesc) {
		this.paymentDesc = paymentDesc;
	}

	public String getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}