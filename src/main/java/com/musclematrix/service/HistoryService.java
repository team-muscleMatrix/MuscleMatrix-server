package com.musclematrix.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.History;
import com.musclematrix.repository.HistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryService {
	
	private final HistoryRepository historyRepository;
	
	//teacher_id로 약력을 전부 찾아오기
	@Transactional
	public List<History> findAllByTeacherId(long teacher_id){
		return historyRepository.findAllByTeacherId(teacher_id);
	}
	
	//약력 저장
	@Transactional
	public void save(History history) {
		historyRepository.save(history);
	}
	
	//강사 id와 일치하는 약력들을 전부 삭제
	@Transactional
	public void deleteById(long teacher_id) {
		historyRepository.deleteByTeacherId(teacher_id);
	}

}
