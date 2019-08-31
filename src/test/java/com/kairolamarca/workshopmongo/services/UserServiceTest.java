package com.kairolamarca.workshopmongo.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.kairolamarca.workshopmongo.domain.User;
import com.kairolamarca.workshopmongo.dto.UserDTO;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	@Mock
	UserService us;
	
	@Test
	public void somar_given_two_int_should_Return_sum() {
		UserService us = new UserService();
		int resultado = us.soma(5, 5);
		
		//assertEquals(10, resultado);
		
		assertThat(resultado, equalTo(10));
	}
	
	@Test
	public void testMock() {
		
		UserDTO uDTO = new UserDTO();
		
		User u = new User();
		
		u.setId("1");
		u.setEmail("noe@dasuaconta.com");
		u.setName("Noe");
		
		Mockito.when(us.fromDTO(uDTO)).thenReturn(u);
		
		User u2 = us.fromDTO(uDTO);
		
		assertThat(u2.getId(), equalTo("1"));
		assertThat(u2.getName(), equalTo("Noe"));
		assertThat(u2.getEmail(), equalTo("noe@dasuaconta.com"));
		
		
		
	}

}
