package com.musclematrix.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.musclematrix.domain.Event;
import com.musclematrix.service.EventService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProgramController {

	private final EventService eventService;
	
	@GetMapping("/program/program")
	public String viewProgram(Model model) {
		
		List<Event> mondays = eventService.getEventsByStatusOne();
		List<Event> tuesdays = eventService.getEventsByStatusTwo();
		List<Event> wednesdays = eventService.getEventsByStatusThree();
		List<Event> thursdays = eventService.getEventsByStatusFour();
		List<Event> fridays = eventService.getEventsByStatusFive();
		
		model.addAttribute("mondays", mondays);
		model.addAttribute("tuesdays", tuesdays);
		model.addAttribute("wednesdays", wednesdays);
		model.addAttribute("thursdays", thursdays);
		model.addAttribute("fridays", fridays);

		return "/program/program";
	}
}
