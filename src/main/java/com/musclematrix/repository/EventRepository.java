package com.musclematrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musclematrix.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
