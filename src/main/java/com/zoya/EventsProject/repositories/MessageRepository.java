package com.zoya.EventsProject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zoya.EventsProject.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
