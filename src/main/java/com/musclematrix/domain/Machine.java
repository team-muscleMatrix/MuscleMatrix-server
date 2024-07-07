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
public class Machine extends Period{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long machine_id;
	
	private String machine_name;
	private String machine_profile;
}
