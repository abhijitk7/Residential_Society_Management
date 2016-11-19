/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sms.entity.Role;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */
public class RoleJpaDao implements IRoleJpaDao {

	@PersistenceContext(unitName = "sms")
	private EntityManager em;

	/*
	 * Retrieve list of Roles
	 * 
	 * @see com.sms.dao.IRoleJpaDao#getAllRoles()
	 */
	@Override
	public List<Role> getAllRoles() {

		final Query query = this.em.createNamedQuery("Role.findAll");
		@SuppressWarnings("unchecked")
		final List<Role> result = query.getResultList();
		return result;
	}
}
