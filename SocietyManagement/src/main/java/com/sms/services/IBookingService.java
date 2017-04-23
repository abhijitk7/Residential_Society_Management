/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.services;

import com.sms.entity.AmenitiesBooking;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Apr 22, 2017
 * @Version 1.0
 */
public interface IBookingService {
	
	void saveBookingDetails(AmenitiesBooking bookingDetails);

}
