package com.musclematrix.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Program extends Period{
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long program_id;
	private String program_content;
	
	@ManyToOne 
  @JoinColumn(name = "teacher_id") 
  private Teacher teacher;

}
