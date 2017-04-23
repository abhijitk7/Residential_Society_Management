/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.entity.Amenity;
import com.sms.entity.BookingStatus;
import com.sms.entity.Flats;
import com.sms.entity.ParkingSlots;
import com.sms.services.IStaticDataService;
/**
 * @author Abhijit A. Kulkarni
 * @Crated on Dec 21, 2016
 * The persistent class for the tbl_sms_user_info database table.
 */
@Controller
@RequestMapping("/data")
public class StaticDataController extends BaseController {
	
	@Autowired
	private IStaticDataService dataService;
	
	private static final Logger log = LoggerFactory.getLogger(StaticDataController.class);
	
	@RequestMapping(value = "/flats", method = RequestMethod.GET)
	ResponseEntity<List<Flats>> getAllFlats() {

		final List<Flats> flatList = this.dataService.getAllFlats();
		return new ResponseEntity<List<Flats>>(flatList,null, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/parkings", method = RequestMethod.GET)
	ResponseEntity<List<ParkingSlots>> getAllParkingSlots() {
		final List<ParkingSlots> parkingSlots = this.dataService.getAllParkingSlots();
		return new ResponseEntity<List<ParkingSlots>>(parkingSlots, null, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/booking/status", method = RequestMethod.GET)
	ResponseEntity<List<BookingStatus>> getBookingStatuses() {
		final List<BookingStatus> bookingStatus = this.dataService.getAllBookingStatus();
		return new ResponseEntity<List<BookingStatus>>(bookingStatus, null, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/amenities", method = RequestMethod.GET)
	ResponseEntity<List<Amenity>> getAmenities() {
		log.debug("********** Retriving all Amenities ****************");
		final List<Amenity> amenity = this.dataService.getAllAmenities();
		return new ResponseEntity<List<Amenity>>(amenity, null, HttpStatus.OK);

	}


}
