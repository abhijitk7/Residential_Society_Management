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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.entity.Amenity;
import com.sms.services.StaticDataService;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */

@Controller
public class MasterController {

	private static final Logger log = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private StaticDataService dataService;

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(final ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "hello";
	}

	@RequestMapping(value = "/Amenities", method = RequestMethod.GET)
	ResponseEntity<List<Amenity>> getAmenities() {
		log.debug("********** Retriving all Amenities ****************");
		final List<Amenity> amenity = this.dataService.getAllAmenities();
		return new ResponseEntity<List<Amenity>>(amenity, null, HttpStatus.OK);

	}

}
