/**
 * 
 */
package com.sms.entity;

import java.io.Serializable;

/**
 * @author Balakrishna
 *
 */
public class AbstractEntity implements IEntity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6634460340147221961L;

	/* (non-Javadoc)
	 * @see com.isjst.entity.IEntity#getId()
	 */
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.isjst.entity.IEntity#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub

	}

}
