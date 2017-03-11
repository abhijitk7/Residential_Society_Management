/**
 * Notice:- This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Abhijit A. Kulkarni (abhikulkarni.1988@gmail.com).
 */
package com.sms.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sms.entity.Flats;
import com.sms.services.StaticDataService;
import com.sms.util.TestUtil;



/**
 * @author Abhijit A. Kulkarni
 * @Crated on Feb 13, 2017
 * @Version 1.0
 */

public class StaticDataControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private StaticDataService dataService;

    @InjectMocks
    private StaticDataController staticDataController;

    @Before
    public void init() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(staticDataController)
                .build();
    }
	
	
	@Test
	public void testGetAllFlats() throws Exception{
		
		List<Flats> flats = Arrays.asList(
	            new Flats(1L, "E-201",Boolean.TRUE,9999L,new Date()),
	            new Flats(2L, "E-202",Boolean.TRUE,9999L,new Date()));
		Mockito.when(dataService.getAllFlats()).thenReturn(flats);
	    mockMvc.perform(get("/getFlats"))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
	            .andExpect(jsonPath("$", hasSize(2)))
	            .andExpect(jsonPath("$[0].flatId", is(1)))
	            .andExpect(jsonPath("$[0].flatName", is("E-201")))
	            .andExpect(jsonPath("$[1].flatId", is(2)))
	            .andExpect(jsonPath("$[1].flatName", is("E-202")));
	    Mockito.verify(dataService,Mockito.times(1)).getAllFlats();
	    Mockito.verifyNoMoreInteractions(dataService);
		
		
	}
	


}
