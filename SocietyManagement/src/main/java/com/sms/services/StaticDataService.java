/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.dao.IAmenitiesJpaDao;
import com.sms.dao.IFlatsJpaDao;
import com.sms.dao.IParkingSlotJpaDao;
import com.sms.entity.Amenity;
import com.sms.entity.Flats;
import com.sms.entity.ParkingSlots;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Jan 02, 2017
 */
public class StaticDataService implements IStaticDataService {
	
	@Autowired
	private IAmenitiesJpaDao amenityDao;
	
	@Autowired
	private IFlatsJpaDao flatsDao;
	
	@Autowired
	private IParkingSlotJpaDao parkingSlotDao;

	@Override
	public List<Amenity> getAllAmenities() {
		
		return amenityDao.getAllAmenities();
	}

	@Override
	public List<Flats> getAllFlats() {
		
		return flatsDao.getAllFlats();
	}

	@Override
	public List<ParkingSlots> getAllParkingSlots() {
		
		return parkingSlotDao.getAllParkingSlot();
		
	}

}
