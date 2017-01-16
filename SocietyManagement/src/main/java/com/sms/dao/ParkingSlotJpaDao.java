package com.sms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.sms.entity.ParkingSlots;

public class ParkingSlotJpaDao extends AbstractSMSDao<ParkingSlots> implements IParkingSlotJpaDao {

	public ParkingSlotJpaDao() {
		super(ParkingSlots.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParkingSlots> getAllParkingSlot() {
		
		Criteria criteria= createCriteria();
		
		criteria.add(Restrictions.eq("active", true));
		
		return criteria.list();
	}

}
