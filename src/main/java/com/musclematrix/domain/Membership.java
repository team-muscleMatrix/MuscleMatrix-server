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
public class Membership extends Period{
	
	@Id
	// primary key 자동 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long membership_id;
	private String membership_email;
	private String membership_password;
	private String membership_name;
	private String membership_gender;
	
	// 0: 탈퇴, 1: 회원
	private int membership_status = 1;
}
