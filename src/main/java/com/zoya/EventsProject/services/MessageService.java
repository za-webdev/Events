package com.zoya.EventsProject.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zoya.EventsProject.models.Message;
import com.zoya.EventsProject.repositories.MessageRepository;

@Service
public class MessageService {
	
private MessageRepository msgRepo;
	
	public MessageService(MessageRepository msgRepo) {
		this.msgRepo=msgRepo;
	}
	
	public Message create(Message message) {
		return msgRepo.save(message);
	}
	
	public ArrayList<Message> findAll() {
		return (ArrayList<Message>) msgRepo.findAll();
	}
}
