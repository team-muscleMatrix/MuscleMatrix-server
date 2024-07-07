package com.musclematrix.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.Machine;
import com.musclematrix.repository.MachineRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MachineService {
	private final MachineRepository machineRepository;
	
	//저장
	@Transactional
	public Machine save(Machine machine) {
		return machineRepository.save(machine);
	}
	
	//모든 기구 정보를 가져오기
	@Transactional
	public List<Machine> findAll(){
		return machineRepository.findAll();
	}

}
