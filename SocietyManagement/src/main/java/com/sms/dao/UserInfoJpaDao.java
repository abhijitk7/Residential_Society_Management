/**
 * 
 */
package com.sms.dao;

import com.sms.entity.UserInfo;

/**
 * @author Balakrishna
 *
 */
public class UserInfoJpaDao extends AbstractSMSDao<UserInfo> implements IUserInfoJpaDao {

	
	
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
	public UserInfo updateUserInfo(UserInfo updateUserInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
