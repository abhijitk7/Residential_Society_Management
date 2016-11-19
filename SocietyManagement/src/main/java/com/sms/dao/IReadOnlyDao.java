package com.sms.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import org.hibernate.Criteria;

import com.sms.entity.IEntity;


public interface IReadOnlyDao<T extends IEntity> extends IDao<T> {

	T findById(Serializable id);
	
	Collection<T> findByQuery(String q);
	Collection<T> findByQuery(String q, final Object ... vs);
	Collection<T> findByQuery(String q, final Map<String, ?> ps);
	
	Collection<T> findByNativeQuery(String q);
	Collection<T> findByNativeQuery(String q, final Object ... vs);
	Collection<T> findByNativeQuery(String q, final Map<String, ?> ps);
	
	Collection<T> findByNamedQuery(String q);
	Collection<T> findByNamedQuery(String q, final Object ... vs);
	Collection<T> findByNamedQuery(String q, final Map<String, ?> ps);
	Collection<T> findByNamedQuery(String q, final Map<String, ?> ps, int maxRows);
	Collection<T> findByNamedQuery(String q, final Map<String, ?> ps, int startIndex, int endIndex);
	
	Criteria createCriteria();
}
