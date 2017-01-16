package com.sms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.sms.entity.Flats;

public class FlatsJpaDao extends AbstractSMSDao<Flats> implements IFlatsJpaDao {

	public FlatsJpaDao() {
		super(Flats.class);
	}

	@Override
	public List<Flats> getAllFlats() {
		
		Criteria criteria= createCriteria();
		
		criteria.add(Restrictions.eq("active", true));
		
		@SuppressWarnings("unchecked")
		List<Flats> flatList=criteria.list();
		
		return flatList;
	}

}
