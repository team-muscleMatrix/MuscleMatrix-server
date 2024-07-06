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
public class History extends Period{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long history_id;
	private String history_content;
	
	
	@ManyToOne // 여러개의 history 행이 하나의 teacher 행으로 연결 될 수 있음. 일대다
  @JoinColumn(name = "teacher_id") // history 테이블의 컬럼명
  private Teacher teacher;
	

}
