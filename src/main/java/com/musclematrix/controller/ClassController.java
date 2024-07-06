package com.musclematrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.musclematrix.DTO.TeacherDTO;
import com.musclematrix.domain.History;
import com.musclematrix.domain.Program;
import com.musclematrix.domain.Teacher;
import com.musclematrix.service.HistoryService;
import com.musclematrix.service.ProgramService;
import com.musclematrix.service.TeacherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ClassController extends BaseController {

	private final HistoryService historyService;
	private final TeacherService teacherService;
	private final ProgramService programService;

	public List<TeacherDTO> getTeacherDTO(List<Teacher> teachers) {
		List<TeacherDTO> tvds = new ArrayList<>();

		for (Teacher teacher : teachers) {
			TeacherDTO tvd = new TeacherDTO();
			long id = teacher.getTeacher_id();

			tvd.setTeacher_id(teacher.getTeacher_id());
			tvd.setTeacher_name(teacher.getTeacher_name());
			tvd.setTeacher_profile(teacher.getTeacher_profile());
			tvd.setTeacher_KAKAOLINK(teacher.getTeacher_KAKAOLINK());

			List<History> historys = historyService.findAllByTeacherId(id);
			List<Program> programs = programService.findAllByTeacherId(id);

//			String historyBody = "";
//			for (History history : historys) {
//				historyBody += history.getHistory_content();
//				historyBody += "<br>";
//			}
//			
//			
//			tvd.setHistoryBody(historyBody);

			tvd.setHistorys(historys);
			tvd.setPrograms(programs);
			log.warn("historys size = " + historys.size());
			log.warn("programs size = " + programs.size());

			tvds.add(tvd);
		}

		return tvds;
	}

	@GetMapping("/class/class")
	public String viewClass(Model model) {

		List<Teacher> teachers = teacherService.findAll();

		// tvd를 넘김
		List<TeacherDTO> tvds = getTeacherDTO(teachers);
		model.addAttribute("tvds", tvds);


		return "/class/class";
//		return "/";
	}

}
