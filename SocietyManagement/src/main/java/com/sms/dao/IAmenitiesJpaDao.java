package com.sms.dao;

import java.util.List;

import com.sms.entity.Amenity;

public interface IAmenitiesJpaDao {

	public List<Amenity> getAllAmenities();
}
