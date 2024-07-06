package com.musclematrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.musclematrix.DTO.TeacherDTO;
import com.musclematrix.domain.Teacher;
import com.musclematrix.service.HistoryService;
import com.musclematrix.service.ProgramService;
import com.musclematrix.service.TeacherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ClassController extends BaseController{
	
	private final HistoryService historyService;
	private final TeacherService teacherService;
	private final ProgramService programService;
	
	
	public List<TeacherDTO> getTeacherDTO(List<Teacher> teachers) {
		List<TeacherDTO> tvds = new ArrayList<>();
		
		for (Teacher teacher : teachers) {
			TeacherDTO tvd = new TeacherDTO();
			tvd.setTeacher_id(teacher.getTeacher_id());
			tvd.setTeacher__name(teacher.getTeacher__name());
			
			
			
			tvds.add(tvd);
		}
		
		
		
		
		return tvds;
	}
	
	
	@GetMapping("/class/class")
	public String viewClass(Model model) {
		
		List<Teacher> teachers= teacherService.findAll();
		
		//tvd를 넘김
		List<TeacherDTO> tvds = getTeacherDTO(teachers);
		model.addAttribute("tvds", tvds);
		
		
		return "/class/class";
	}
	

}
