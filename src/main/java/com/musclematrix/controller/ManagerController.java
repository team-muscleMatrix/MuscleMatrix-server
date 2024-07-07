package com.musclematrix.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.musclematrix.DTO.TeacherDTO;
import com.musclematrix.domain.History;
import com.musclematrix.domain.Machine;
import com.musclematrix.domain.Program;
import com.musclematrix.domain.Teacher;
import com.musclematrix.service.HistoryService;
import com.musclematrix.service.MachineService;
import com.musclematrix.service.ProgramService;
import com.musclematrix.service.TeacherService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ManagerController extends BaseController {

	private final HistoryService historyService;
	private final ProgramService programService;
	private final TeacherService teacherService;
	private final MachineService machineService;
	

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

			tvd.setHistorys(historys);
			tvd.setPrograms(programs);

			tvds.add(tvd);
		}

		return tvds;
	}

	// 관리자 로그인에 성공했는지 확인
	public boolean checkManagerLogin(HttpSession session) {
		return session.getAttribute("managerLogin") == "yes";
	}

	// 관리자 페이지 로그인 뷰
	@GetMapping("/manager/login")
	public String viewManager() {

		return "/manager/login/login";
	}

	// 관리자 페이지 로그아웃
	@GetMapping("/manager/logout")
	public String logoutManager(HttpSession session) {
		session.removeAttribute("managerLogin");
		return "redirect:/"; // 로그아웃시 메인으로 이동
	}

	// 로그인 성공시 강사 관리자페이지로 리 다이렉트
	@PostMapping("/manager/login")
	public String loginSuccess(HttpSession session) {

		session.setAttribute("managerLogin", "yes");

		return "redirect:/manager/teacher";
	}

	// 강사 관리 페이지 뷰
	@GetMapping("/manager/teacher")
	public String viewTeacher(HttpSession session, Model model) {

		if (!checkManagerLogin(session)) // 로그인 안했을때는 로그인뷰로 리다이렉트
			return "redirect:/manager/login";

		List<Teacher> teachers = teacherService.findAll();

		List<TeacherDTO> tvds = getTeacherDTO(teachers);

		model.addAttribute("tvds", tvds);
		model.addAttribute("teacherCnt", teachers.size()); // 총 강사 갯수

		return "/manager/teacher/teacher";
	}

	@Value("${project.uploadpath}")
	private String uploadDir;

	@PostMapping("/manager/teacher/addmachine")
	public String addMachine(@RequestParam("file") MultipartFile file,
			@RequestParam("machine-name") String name) {
		Map<String, Object> response = new HashMap<>();

		if (file.isEmpty()) {
			log.error("파일이 비어있습니다.");

			return "redirect:/manager/teacher";
		}
		
		String machine_profile = null;

		try {
			// 프로젝트 루트 디렉토리 얻기
			String projectDir = System.getProperty("user.dir");

			// 업로드 디렉토리 경로 생성 (절대 경로)
			Path uploadPath = Paths.get(projectDir, uploadDir).toAbsolutePath().normalize();

			// 디렉토리가 존재하지 않으면 생성
			Files.createDirectories(uploadPath);

			// 원본 파일명에서 확장자 추출
			String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
			String fileExtension = StringUtils.getFilenameExtension(originalFilename);

			// 고유한 파일명 생성
			String fileName = UUID.randomUUID().toString() + "." + fileExtension;
			Path filePath = uploadPath.resolve(fileName);

			// 파일 저장
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

			machine_profile = "/upload/" + fileName;
			
			log.info("파일 저장 경로: " + filePath.toString());
			log.info("파일 업로드 성공");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			log.error("파일 업로드 실패");

			return "redirect:/manager/teacher";
		}
		
		//기구를 DB에 저장
		Machine machine = new Machine();
		machine.setMachine_name(name);
		machine.setMachine_profile(machine_profile);
		machineService.save(machine);
		
		return "redirect:/manager/teacher";
	}
	
	
	
	
	
//	
//	@PostMapping("/manager/teacher/addteacher")
//  public String addTeacher(
//          @RequestParam("teacherImageInput") MultipartFile file,
//          @RequestParam("teacher-name") String name,
//          @RequestParam("teacher-link") String link,
//          @RequestParam("teacher-background") String[] backgrounds,
//          @RequestParam("teacher-program") String[] programs) {
//      
//      Map<String, Object> response = new HashMap<>();
//
//      if (file.isEmpty()) {
//  			log.error("파일이 비어있습니다.");
//
//  			return "redirect:/manager/teacher";
//  		}
//
//      try {
//          // 프로젝트 루트 디렉토리 얻기
//          String projectDir = System.getProperty("user.dir");
//
//          // 업로드 디렉토리 경로 생성 (절대 경로)
//          Path uploadPath = Paths.get(projectDir, uploadDir).toAbsolutePath().normalize();
//
//          // 디렉토리가 존재하지 않으면 생성
//          Files.createDirectories(uploadPath);
//
//          // 원본 파일명에서 확장자 추출
//          String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
//          String fileExtension = StringUtils.getFilenameExtension(originalFilename);
//
//          // 고유한 파일명 생성
//          String fileName = UUID.randomUUID().toString() + "." + fileExtension;
//          Path filePath = uploadPath.resolve(fileName);
//
//          // 파일 저장
//          Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//          response.put("success", true);
//          response.put("message", "파일 업로드 성공");
//          response.put("fileName", fileName);
////          return ResponseEntity.ok(response);
//      } catch (IOException e) {
//          e.printStackTrace();
//          response.put("success", false);
//          response.put("message", "파일 업로드 실패: " + e.getMessage());
////          return ResponseEntity.internalServerError().body(response);
//      }
//  }
	
	
	
	
	

}
