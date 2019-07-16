package com.amal.rajeeda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amal.rajeeda.dao.LoginRepo;
import com.amal.rajeeda.model.User;

@Service
public class UserServicesImpl implements UserService {

	@Autowired
	LoginRepo users;

	@Override
	public User getUser() {	
		
		User user = null;
		try {
			user=  users.getOne(1);
		} catch (Exception e) {
			System.out.println("error in fetching data- Please check the DB");
		}
		return user;
	}
	
	
}
