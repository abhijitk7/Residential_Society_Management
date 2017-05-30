/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sms.controller.StaticDataController;
import com.sms.entity.AmenitiesBooking;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Apr 22, 2017
 * @Version 1.0
 */
public class AmenityBookingJpaDao extends AbstractSMSDao<AmenitiesBooking> implements IAmenityBookingJpaDao {
	
	private static final Logger log = LoggerFactory.getLogger(StaticDataController.class);

	/**
	 * @param ec
	 */
	public AmenityBookingJpaDao() {
		super(AmenitiesBooking.class);
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IAmenityBookingJpaDao#saveBookingDetails(com.sms.entity.AmenitiesBooking)
	 */
	@Override
	public void saveBookingDetails(AmenitiesBooking bookingDetails) {
		
		try{
			save(bookingDetails);
			
		}catch(Exception ex){
			log.debug("Exception occured while saving booking info "+ex);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IAmenityBookingJpaDao#getBookingDetails(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AmenitiesBooking> getBookingDetails(Long userId) {
		
		List<AmenitiesBooking> listOfBookings=null;
		
		try{
			final Criteria criteria = createCriteria();
			criteria.add(Restrictions.eq("requestedByUserInfoId", userId));
			listOfBookings=criteria.list();
		}catch(Exception ex){
			
		}
		
		return listOfBookings;
	}



}
