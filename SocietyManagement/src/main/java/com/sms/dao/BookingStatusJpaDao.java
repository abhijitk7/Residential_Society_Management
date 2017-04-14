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
import org.hibernate.criterion.Order;

import com.sms.entity.BookingStatus;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Apr 14, 2017
 * @Version 1.0
 */
public class BookingStatusJpaDao extends AbstractSMSDao<BookingStatus> implements IBookingStatusJpaDao {

	/**
	 * @param ec
	 */
	public BookingStatusJpaDao() {
		super(BookingStatus.class);
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IBookingStatusJpaDao#getAllBookingStatus()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BookingStatus> getAllBookingStatus() {
		
		Criteria criteria=this.createCriteria();
		criteria.addOrder(Order.asc("bookingStatus"));
		
		return criteria.list();
		
	}


}
