package com.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sms.entity.Amenity;

public class AmenityJpaDao implements IAmenitiesJpaDao {
	
	@PersistenceContext(unitName="sms")
    private EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Amenity> getAllAmenities() {
		
		Query query=em.createNamedQuery("Amenity.findAll");
		List<Amenity> result=query.getResultList();
		return result;
		
	}


}
