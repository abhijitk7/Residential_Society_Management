package com.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.dao.IAmenitiesJpaDao;
import com.sms.entity.Amenity;

public class StaticDataService implements IStaticDataService {
	
	@Autowired
	private IAmenitiesJpaDao amenityDao;

	@Override
	public List<Amenity> getAllAmenities() {
		
		return amenityDao.getAllAmenities();
	}

}
