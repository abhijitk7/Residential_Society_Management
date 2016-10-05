package com.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.dao.AmenityJpaDao;
import com.sms.entity.Amenity;

public class StaticDataService implements IStaticDataService {
	
	@Autowired
	private AmenityJpaDao amenityDao;

	@Override
	public List<Amenity> getAllAmenities() {
		
		return amenityDao.getAllAmenities();
	}

}
