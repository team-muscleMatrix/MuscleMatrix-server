package com.musclematrix.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.History;
import com.musclematrix.domain.Program;
import com.musclematrix.repository.ProgramRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgramService{
	
	private final ProgramRepository programRepository;
	
	//저장
	@Transactional
	public Program save(Program program) {
		return programRepository.save(program);
	}
	
	//강사 id로 진행 프로그램을 전부 찾아오기
	@Transactional
	public List<Program> findAllByTeacherId(long teacher_id){
		return programRepository.findAllByTeacherId(teacher_id);
	}
	
	//강사 id와 같은 모든 프로그램 삭제
	@Transactional
	public void deleteById(long teacher_id) {
		programRepository.deleteByTeacherId(teacher_id);
	}
	
	
}
