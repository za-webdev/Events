package com.zoya.EventsProject.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zoya.EventsProject.models.MyEvent;
import com.zoya.EventsProject.repositories.MyEventRepository;

@Service
public class MyEventService {
	
	private MyEventRepository eventRepo;
	
	public MyEventService(MyEventRepository eventRepo) {
		this.eventRepo=eventRepo;
	}
	
	public MyEvent create(MyEvent myEvent) {
		return eventRepo.save(myEvent);
	}
	
	public MyEvent update(MyEvent myEvent) {
		return eventRepo.save(myEvent);
	}
	
	public ArrayList<MyEvent> findAll() {
		return (ArrayList<MyEvent>) eventRepo.findAll();
	}
	
	public MyEvent findOne(Long id) {
		return eventRepo.findOne(id);
	}
	
	public void destroy(Long id) {
        eventRepo.delete(id);
    }


	
}

