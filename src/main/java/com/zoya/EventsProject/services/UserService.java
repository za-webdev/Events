package com.zoya.EventsProject.services;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.zoya.EventsProject.models.MyEvent;
import com.zoya.EventsProject.models.User;
import com.zoya.EventsProject.repositories.UserRepository;



@Service
public class UserService {
	
	private BCryptPasswordEncoder bcrypt;
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository,BCryptPasswordEncoder bcrypt) {
		this.userRepository=userRepository;
		this.bcrypt=bcrypt;
	}
	
	public User create(Map <String,String> body) {
		ArrayList<User> users= userRepository.findAll();
		String userLevel= "user";
		if (users.size()<1) {
			userLevel="admin";
		}
		return userRepository.save(new User(
				body.get("firstName"),
				body.get("lastName"),
				body.get("email"),
				body.get("location"),
				userLevel,
				bcrypt.encode(body.get("password"))
				
		));
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	public void update(User user) {
        userRepository.save(user);
    }
	
	public ArrayList<User> findAll() {
		return (ArrayList<User>) userRepository.findAll();
	}
	
	
}

