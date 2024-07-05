package com.musclematrix.service;

import org.springframework.stereotype.Service;

import com.musclematrix.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
	
	private final EventRepository eventRepository;
}
