package com.musclematrix.service;

import java.util.List;

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
	
	

}
