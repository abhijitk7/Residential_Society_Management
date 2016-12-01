/**
 * 
 */
package com.sms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sms.entity.IEntity;

/**
 * @author Balakrishna
 *
 */
public abstract class AbstractSMSDao<T extends IEntity> extends AbstractJpaDao<T> {

	public AbstractSMSDao(Class<T> ec) {
		
		super(ec);
	}

	@PersistenceContext(unitName = "sms")
	private EntityManager em;

	@Override
	protected EntityManager getEm() {
		
		return em;
	}
	
	
	
	
}
