package com.zoya.EventsProject.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.zoya.EventsProject.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
	ArrayList<User> findAll();

}
