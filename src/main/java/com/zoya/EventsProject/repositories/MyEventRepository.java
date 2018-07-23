package com.zoya.EventsProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zoya.EventsProject.models.MyEvent;

public interface MyEventRepository extends CrudRepository<MyEvent, Long> {
	
	@Query(value="SELECT * FROM my_events ORDER BY date ASC;", nativeQuery=true)
	List<MyEvent> findAll();

}
