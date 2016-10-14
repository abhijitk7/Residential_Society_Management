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

@Controller
public class MasterController {

	private static final Logger log = LoggerFactory
			.getLogger(MasterController.class);

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
