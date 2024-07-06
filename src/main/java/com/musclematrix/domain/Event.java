package com.musclematrix.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Event extends Period{
	
	@Id
	// primary key 자동 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long event_id;
	private String event_name;
	private String event_content;
	
	// 1:월, 2:화, 3:수, 4:목, 5:금
	private int event_status;
}
