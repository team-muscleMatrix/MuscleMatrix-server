package com.musclematrix.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.Teacher;
import com.musclematrix.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {
	
	private final TeacherRepository teacherRepository;
	
	//저장
	@Transactional
	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	//모든 강사정보를 가져오기
	@Transactional
	public List<Teacher> findAll(){
		return teacherRepository.findAllByStatus();
	}
	
	
	//프로필 이미지 파일명으로 강사를 찾기
	@Transactional
	public Teacher findByTeacherProfile(String teacherProfile) {
		return teacherRepository.findByTeacherProfile(teacherProfile);
	}
	
	//강사 이름으로 검색
	@Transactional
	public List<Teacher> findAllByName(String name){
		return teacherRepository.findAllByName(name);
	}
	
	//강사 아이디로 검색
	public Teacher findById(long teacher_id) {
		return teacherRepository.findById(teacher_id).orElse(null); //없다면 null값 리턴
	}
	
	//아이디로 강사 삭제
	@Transactional
	public void deleteById(long teacher_id) {
		teacherRepository.deleteById(teacher_id);
	}
	
 	

}
