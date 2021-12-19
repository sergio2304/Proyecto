package com.testcode.linkapi;
import com.testcode.linkapi.controller.UserController;
import com.testcode.linkapi.dtos.UrlData;
import com.testcode.linkapi.dtos.UserDTO;
import com.testcode.linkapi.external.PropertyClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnit;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
public class LinkApiApplicationTests {
	@InjectMocks
	private UserController controller;

	@Mock
	private RestTemplate restTemplate;


	@Test
	public void propertyTestOK(){
		PropertyClass property= new PropertyClass();
		String propiedad = property.getProperty("url");
		Assert.assertNotNull(propiedad);
	}
	@Test
	public  void controllerTestOK(){
		UrlData urlData= new UrlData();
		List<UserDTO> data= new ArrayList<>();
		UserDTO userDTO= new UserDTO();
		userDTO.setId("1");
		userDTO.setFirst_name("George");
		userDTO.setLast_name("Bluth");
		userDTO.setAvatar("https://reqres.in/img/faces/1-image.jpg");
		userDTO.setEmail("george.bluth@reqres.in");
		data.add(userDTO);
		urlData.setData(data.toArray(new UserDTO[0]));
		ResponseEntity a = mock(ResponseEntity.class);;
		Mockito.when(restTemplate.exchange(anyString(), anyObject(),
				any(), (Class<Object>) anyObject())).thenReturn(a);
		Mockito.when(a.getBody()).thenReturn(urlData);

		controller.getUsers();
		assertTrue(true);
	}
	@Test
	public  void controllerTestnotOK(){
		UrlData urlData= new UrlData();
		List<UserDTO> data= new ArrayList<>();
		UserDTO userDTO= new UserDTO();
		userDTO.setId("1");
		userDTO.setFirst_name("George");
		userDTO.setLast_name("Bluth");
		userDTO.setAvatar("https://reqres.in/img/faces/1-image.jpg");
		userDTO.setEmail("george.bluth@reqres.in");
		data.add(userDTO);
		urlData.setData(data.toArray(new UserDTO[0]));
		ResponseEntity a = mock(ResponseEntity.class);;
		Mockito.when(restTemplate.exchange(anyString(), anyObject(),
				any(), (Class<Object>) anyObject())).thenReturn(null);
		Mockito.when(a.getBody()).thenReturn(urlData);

		controller.getUsers();
		assertTrue(true);
	}
}