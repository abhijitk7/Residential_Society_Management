package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.services.StaticDataService;

@Controller
public class MasterController {
	
	   @Autowired
	   private StaticDataService dataService;
	
	   @RequestMapping(method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");

	      return "hello";
	   }
	   
	   @RequestMapping(value="/Amenities",method = RequestMethod.GET)
	   public void getAmenities(){
		   dataService.getAllAmenities();
	   }
}
