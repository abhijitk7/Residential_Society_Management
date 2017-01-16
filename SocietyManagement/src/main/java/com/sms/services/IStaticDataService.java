package com.sms.services;

import java.util.List;

import com.sms.entity.Amenity;
import com.sms.entity.Flats;
import com.sms.entity.ParkingSlots;

public interface IStaticDataService {
	
	List<Amenity> getAllAmenities();
	
	List<Flats> getAllFlats();
	
	List<ParkingSlots> getAllParkingSlots();
}
