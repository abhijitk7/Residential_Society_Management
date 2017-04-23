/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sms.controller.StaticDataController;
import com.sms.dao.IAmenityBookingJpaDao;
import com.sms.entity.AmenitiesBooking;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Apr 22, 2017
 * @Version 1.0
 */
public class BookingService implements IBookingService {
	
	private static final Logger log = LoggerFactory.getLogger(StaticDataController.class);
	
	@Autowired
	private IAmenityBookingJpaDao amenityBookingDao;

	/* (non-Javadoc)
	 * @see com.sms.services.IBookingService#saveBookingDetails(com.sms.entity.AmenitiesBooking)
	 */
	@Override
	@Transactional
	public void saveBookingDetails(AmenitiesBooking bookingDetails) {
		
		try{
			amenityBookingDao.saveBookingDetails(bookingDetails);
		}catch(Exception ex){
			log.debug("Exception occured while saving booking details "+ex);
		}
	}

}
