package com.musclematrix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.musclematrix.domain.Event;
import com.musclematrix.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

	private final EventRepository eventRepository;
	
	// 월요일
	public List<Event> getEventsByStatusOne() {
		return eventRepository.findEventsByStatusOne();
	}
  
	// 화요일
	public List<Event> getEventsByStatusTwo() {
		return eventRepository.findEventsByStatusTwo();
	}
  
	// 수요일
	public List<Event> getEventsByStatusThree() {
		return eventRepository.findEventsByStatusThree();
	}
  
	// 목요일
	public List<Event> getEventsByStatusFour() {
		return eventRepository.findEventsByStatusFour();
	}
  
	// 금요일
	public List<Event> getEventsByStatusFive() {
		return eventRepository.findEventsByStatusFive();
	}
	
}
