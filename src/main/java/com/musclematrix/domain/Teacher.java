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
public class Teacher extends Period{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacher_id;
	
	private String teacher__name;
	private String teacher_profile;
	private String teacher_KAKAOLINK;
	private int teacher_STATUS = 1; //근무중
}
