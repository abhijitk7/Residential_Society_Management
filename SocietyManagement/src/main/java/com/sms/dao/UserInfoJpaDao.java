/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sms.entity.UserInfo;

/**
 * @author Balakrishna
 * @Crated on Feb 26, 2017
 * @Version 1.0
 */
public class UserInfoJpaDao extends AbstractSMSDao<UserInfo> implements IUserInfoJpaDao {

	private static final Logger log = LoggerFactory.getLogger(UserInfoJpaDao.class);
	
	public UserInfoJpaDao() {
		super(UserInfo.class);
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserInfoDao#registerUserInfo(com.sms.entity.UserInfo)
	 */
	@Override
	public UserInfo persistUserInfo(UserInfo userInfo) {
		
		save(userInfo);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserInfoDao#updateUserInfo(com.sms.entity.UserInfo)
	 */
	@Override
	public String updateUserInfo(UserInfo userInfo) {
		
		log.debug("----------"+SecurityContextHolder.getContext().getAuthentication().getName()+"----------");
		try{
			update(userInfo);
			return "true";
		}catch(Exception e){
			log.error("Exception while updating user info for user-->"+SecurityContextHolder.getContext().getAuthentication().getName()+" and exception is "+e.getMessage());
			return "false";
		}
	}

	/* (non-Javadoc)
	 * @see com.sms.dao.IUserInfoJpaDao#searchMemberDetails(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Set<UserInfo> searchMemberDetails(String searchText) {
		
		List<UserInfo> result=null;
		
		
		Set<UserInfo> resultSet=null;
		
		Criteria criteria=createCriteria();
		
		try{
			
			result=new ArrayList<UserInfo>();
			
			Disjunction disjunction=Restrictions.disjunction();
			
			String token='%'+searchText.trim().toLowerCase()+'%';
			
			disjunction.add(Restrictions.ilike("primFirstName", token));
			
			disjunction.add(Restrictions.ilike("primLastName", token));
			
			disjunction.add(Restrictions.ilike("primMiddleName", token));
			
			criteria.add(disjunction);
			
			result=criteria.list();
			
			resultSet=new HashSet<UserInfo>();
			
			resultSet.addAll(result);
			
			
		}catch(DataAccessException de){
			log.error("Exception occured while searching user info "+de.getCause());
		}catch(Exception e){
			log.error("Exception occured while searching user info "+e.getCause());
		}
		
		
		return resultSet;
	}

}
