/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sms.exception.CustomGenericException;

/**
 * @author Abhijit Kulkarni
 * @since 12 Dec 2016
 * @version 1.0
 */

@Controller
public class BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="Username or Password is incorrect")
	@ExceptionHandler(CustomGenericException.class)
	public ResponseEntity<Void> handleCustomException(CustomGenericException ex) {
				
		log.error("********Exception occured because...."+ex.getErrMsg());
		
		log.error("********Exception occured with error code...."+ex.getErrCode());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Void> handleAllException(Exception ex) {

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
