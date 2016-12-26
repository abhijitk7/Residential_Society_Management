/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sms.entity.Role;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Nov 12, 2016
 * @Version 1.0
 */
public class RoleJpaDao extends AbstractSMSDao<Role> implements IRoleJpaDao {

	public RoleJpaDao() {
		super(Role.class);
	}

	/*
	 * Retrieve list of Roles
	 * 
	 * @see com.sms.dao.IRoleJpaDao#getAllRoles()
	 */
	@Override
	public List<Role> getAllRoles() {

//		final Query query = this.em.createNamedQuery("Role.findAll");
//		@SuppressWarnings("unchecked")
//		final List<Role> result = query.getResultList();
//		return result;
		return null;
	}

	@Override
	public List<String> getRolesByIds(Set<Long> roleIds) {
		
		final Criteria criteria = this.createCriteria();
		
		ProjectionList projection=Projections.projectionList();
		
		projection.add(Projections.property("roleName"));

		criteria.setProjection(projection);
		
		criteria.add(Restrictions.in("roleId", roleIds));
		
		@SuppressWarnings("unchecked")
		final List<String> roles = criteria.list();
		
		return roles;
	}
}
