/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.dao;

import java.util.List;

import com.sms.entity.Flats;

/**
 * @author Abhijit A. Kulkarni
 * @Crated on Jan 02, 2017
 */
public interface IFlatsJpaDao {
	
	List<Flats> getAllFlats();

}
