/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.exception;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Dec 12, 2016
 * @Version 1.0
 */
public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 4785582597643970171L;
	
	private int errCode;
	private String errMsg;

	public CustomGenericException(int errorCode, String errMsg) {
		this.setErrCode(errorCode);
		this.setErrMsg(errMsg);
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
