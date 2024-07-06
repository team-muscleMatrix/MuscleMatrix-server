package com.musclematrix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musclematrix.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	// 월요일
	@Query("SELECT e FROM Event e WHERE e.event_status = 1")
	List<Event> findEventsByStatusOne();
	
	// 화요일
	@Query("SELECT e FROM Event e WHERE e.event_status = 2")
	List<Event> findEventsByStatusTwo();
  
	// 수요일
	@Query("SELECT e FROM Event e WHERE e.event_status = 3")
	List<Event> findEventsByStatusThree();
  
	// 목요일
	@Query("SELECT e FROM Event e WHERE e.event_status = 4")
	List<Event> findEventsByStatusFour();
	
	// 금요일
	@Query("SELECT e FROM Event e WHERE e.event_status = 5")
	List<Event> findEventsByStatusFive();
}
