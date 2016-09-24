package com.sms.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_sms_payment_type database table.
 * 
 */
@Entity
@Table(name="tbl_sms_payment_type")
@NamedQuery(name="PaymentType.findAll", query="SELECT p FROM PaymentType p")
public class PaymentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_type_id")
	private int paymentTypeId;

	private byte active;

	@Column(name="payment_type_desc")
	private String paymentTypeDesc;

	private int version;

	public PaymentType() {
	}

	public int getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getPaymentTypeDesc() {
		return this.paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}