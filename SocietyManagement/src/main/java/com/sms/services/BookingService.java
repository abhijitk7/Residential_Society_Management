/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sms.controller.StaticDataController;
import com.sms.dao.IAmenityBookingJpaDao;
import com.sms.dao.IUserInfoJpaDao;
import com.sms.entity.AmenitiesBooking;
import com.sms.entity.UserInfo;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Apr 22, 2017
 * @Version 1.0
 */
public class BookingService implements IBookingService {

	private static final Logger log = LoggerFactory.getLogger(StaticDataController.class);

	@Autowired
	private IAmenityBookingJpaDao amenityBookingDao;

	@Autowired
	private IUserInfoJpaDao userInfoDao;


	/* (non-Javadoc)
	 * @see com.sms.services.IBookingService#saveBookingDetails(com.sms.entity.AmenitiesBooking)
	 */
	@Override
	@Transactional
	public void saveBookingDetails(final AmenitiesBooking bookingDetails) {

		try{
			this.amenityBookingDao.saveBookingDetails(bookingDetails);
		}catch(final Exception ex){
			log.debug("Exception occured while saving booking details "+ex);
		}
	}

	/* (non-Javadoc)
	 * @see com.sms.services.IBookingService#getBookingDetails(java.lang.Long)
	 */
	@Override
	public List<AmenitiesBooking> getBookingDetails(final Long userInfoId) {

		List<AmenitiesBooking> listOfBookings=null;
		try{
			final UserInfo userInfo = this.userInfoDao.findUserInfoById(userInfoId);
			listOfBookings = this.amenityBookingDao.getBookingDetails(userInfo);
		}catch(final Exception ex){
			log.error(ex.getMessage(), ex);
		}
		return listOfBookings;
	}

}
