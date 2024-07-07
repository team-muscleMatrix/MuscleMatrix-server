package com.musclematrix.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.musclematrix.domain.Machine;
import com.musclematrix.service.MachineService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HealthController extends BaseController{
	private final MachineService machineService;
	
	
	@GetMapping("/health/health")
	public String viewHealth(Model model) {
		
		List<Machine> machines = machineService.findAll();
		
	// Set1: 인덱스 0부터 5까지
		List<Machine> set1 = machines.subList(0, Math.min(6, machines.size()));
		// Set2: 인덱스 6부터 11까지
		List<Machine> set2 = machines.subList(6, Math.min(12, machines.size()));
		// Set3: 인덱스 12부터 17까지
		List<Machine> set3 = machines.subList(12, Math.min(18, machines.size()));
		
		// Model에 set1, set2, set3 추가
		model.addAttribute("set1", set1);
		model.addAttribute("set2", set2);
		model.addAttribute("set3", set3);
		
		return "/health/health";
	}
	
	

}
