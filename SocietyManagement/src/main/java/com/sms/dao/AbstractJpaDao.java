/**
 * 
 */
package com.sms.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.sms.entity.IEntity;

/**
 * @author Balakrishna
 *
 */
public abstract class AbstractJpaDao<T extends IEntity> extends AbstractReadOnlyJpaDao<T> implements IDao<T> {

	public AbstractJpaDao(Class<T> ec) {
		super(ec);
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IDao#save(com.isjst.entity.IEntity)
	 */
	@Override
	public void save(T entity) {
		
		EntityManager em = getEm();
		em.persist(entity);
		em.flush();
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IDao#saveAll(java.util.Collection)
	 */
	@Override
	public void saveAll(Collection<T> entity) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IDao#update(com.isjst.entity.IEntity)
	 */
	@Override
	public T update(T entity) {
		
		T updatedEntity=getEm().merge(entity);
		getEm().flush();
		
		return updatedEntity;
		
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IDao#delete(com.isjst.entity.IEntity)
	 */
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IDao#softDelete(com.isjst.entity.IEntity)
	 */
	@Override
	public void softDelete(T entity) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IDao#refresh(com.isjst.entity.IEntity)
	 */
	@Override
	public void refresh(T entity) {
		// TODO Auto-generated method stub
		
	}
	
}
