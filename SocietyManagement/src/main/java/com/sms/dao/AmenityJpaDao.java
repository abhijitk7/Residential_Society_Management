/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.sms.entity.Amenity;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */
public class AmenityJpaDao extends AbstractSMSDao<Amenity> implements IAmenitiesJpaDao {

	/*@PersistenceContext(unitName = "sms")
	private EntityManager em;*/
	
	public AmenityJpaDao() {
		super(Amenity.class);
	}

	@Override
	public List<Amenity> getAllAmenities() {

		//final Query query = this.em.createNamedQuery("Amenity.findAll");
		//final List<Amenity> result = query.getResultList();
		
		final Criteria criteria = createCriteria();
		@SuppressWarnings("unchecked")
		final List<Amenity> result = (List<Amenity>) criteria.list();
		
		return result;

	}

}
