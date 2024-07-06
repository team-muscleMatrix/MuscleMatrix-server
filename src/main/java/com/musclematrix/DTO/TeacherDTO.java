package com.musclematrix.DTO;

import java.util.List;

import com.musclematrix.domain.History;
import com.musclematrix.domain.Program;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {
	//teacher
	private long teacher_id;
	private String teacher_name;
	private String teacher_profile;
	private String teacher_KAKAOLINK; //카카오톡 오픈채팅방 링크
	private int teacher_STATUS;
	
	//해당 강사가 가진 모든 약력들
	private List<History> historys;
	//histroy강사의 약력을 전부 가져와서 한줄마다<br>을 추가해서 기록
	private String historyBody;
	
	//해당 강사가 가진 모든 program들
	private List<Program> programs;
	
}
