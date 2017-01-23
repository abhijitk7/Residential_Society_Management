/**
 * 
 */
package com.sms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.sms.entity.UserInfo;

/**
 * @author Balakrishna
 *
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

}
