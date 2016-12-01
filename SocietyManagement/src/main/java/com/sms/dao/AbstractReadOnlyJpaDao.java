/**
 * 
 */
package com.sms.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.stereotype.Repository;

import com.sms.entity.IEntity;

/**
 * @author Balakrishna
 *
 */
@Repository
public abstract class AbstractReadOnlyJpaDao<T extends IEntity> implements IReadOnlyDao<T> {

	protected final Class<T> ec;

	public AbstractReadOnlyJpaDao(final Class<T> ec) {
		this.ec = ec;
	}
	
	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findById(java.io.Serializable)
	 */
	@Override
	public T findById(Serializable id) {

		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByQuery(java.lang.String)
	 */
	@Override
	public Collection<T> findByQuery(String q) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByQuery(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Collection<T> findByQuery(String q, Object... vs) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public Collection<T> findByQuery(String q, Map<String, ?> ps) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNativeQuery(java.lang.String)
	 */
	@Override
	public Collection<T> findByNativeQuery(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNativeQuery(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Collection<T> findByNativeQuery(String q, Object... vs) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNativeQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public Collection<T> findByNativeQuery(String q, Map<String, ?> ps) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNamedQuery(java.lang.String)
	 */
	@Override
	public Collection<T> findByNamedQuery(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNamedQuery(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Collection<T> findByNamedQuery(String q, Object... vs) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNamedQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public Collection<T> findByNamedQuery(String q, Map<String, ?> ps) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNamedQuery(java.lang.String, java.util.Map, int)
	 */
	@Override
	public Collection<T> findByNamedQuery(String q, Map<String, ?> ps,
			int maxRows) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#findByNamedQuery(java.lang.String, java.util.Map, int, int)
	 */
	@Override
	public Collection<T> findByNamedQuery(String q, Map<String, ?> ps,
			int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.dao.IReadOnlyDao#createCriteria()
	 */
	@Override
	public Criteria createCriteria() {
		
		SessionFactory sessionFactory = ((HibernateEntityManager) getEm()).getSession().getSessionFactory();
		Session session = sessionFactory.openSession();
		
		return session.createCriteria(ec);
	}
	
	protected Session getSession() {

		return null;
	}
	
	protected abstract EntityManager getEm();
}
