package com.amal.rajeeda;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.amal.rajeeda.dao.LoginRepo;
import com.amal.rajeeda.model.User;
import com.amal.rajeeda.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServicesTest {

	@Autowired
	UserService userServices;
	
	@MockBean
	LoginRepo loginRepo;
	
	@Test
	public void getUserTest() {
		ArrayList<User> userList = new ArrayList<User>();		
		User usr = getUserData(1,"admin","admin@1234");
		
		userList.add(usr);
		when(loginRepo.getOne(1)).thenReturn(usr);		
		assertEquals(userList.get(0).getPassword(),userServices.getUser().getPassword());
		assertEquals(userList.get(0).getUsername(),userServices.getUser().getUsername());
	}
	
	private User getUserData(int id, String username, String password) {
		User usr =new User();
		usr.setId(id);
		usr.setUsername(username);
		usr.setPassword(password);
		
		return usr;
		
	}


}
