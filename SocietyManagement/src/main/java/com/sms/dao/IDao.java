/**
 * 
 */
package com.sms.dao;

import java.util.Collection;

import com.sms.entity.IEntity;

/**
 * @author Balakrishna
 *
 */
public interface IDao<T extends IEntity> {

	void save(T entity);
	void saveAll(Collection<T> entity);
	T update(T entity);
	void delete(T entity);
	void softDelete(T entity);
	void refresh(T entity);
}
