package com.musclematrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.musclematrix.DTO.TeacherDTO;
import com.musclematrix.domain.Teacher;
import com.musclematrix.service.HistoryService;
import com.musclematrix.service.ProgramService;
import com.musclematrix.service.TeacherService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ApplyController extends BaseController{
	
	// PT선생님
	private final TeacherService teacherService;
	
	// PT선생님 약력
	private final HistoryService historyService;
	
	// PT선생님 진행 프로그램
	private final ProgramService programService;
	
	@GetMapping("/apply/apply")
	public String viewApply() {
		List<Teacher> tvds = new ArrayList<Teacher>();
		List<Teacher> teachers = teacherService.findAll();
		
		for (Teacher teacher : teachers) {
			TeacherDTO tvd = new TeacherDTO();
			tvd.setTeacher__name(teacher.getTeacher__name());
			tvd.setTeacher_profile(teacher.getTeacher_profile());
			tvd.setTeacher_KAKAOLINK(teacher.getTeacher_KAKAOLINK());
			
			
		}
		
		return "/apply/apply";
	}
}
