package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.musclematrix.service.EventService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProgramController {

	private final EventService eventService;
	
	@GetMapping("/program/program")
	public String viewProgram() {
		
		return "/program/program";
	}
}
