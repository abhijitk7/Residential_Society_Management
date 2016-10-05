package com.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sms.entity.Amenity;
import com.sms.util.JpaUtils;

public class AmenityJpaDao implements IAmenitiesJpaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Amenity> getAllAmenities() {
		EntityManager em = JpaUtils.createEntityManager();
		Query q = em.createNamedQuery("Amenity.findAll");
		return q.getResultList();
	}


}
