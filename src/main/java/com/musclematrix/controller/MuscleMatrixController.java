package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MuscleMatrixController extends BaseController {

	@GetMapping("/musclematrix/musclematrix")
	public String viewMuscleMatrixe() {
		return "/musclematrix/musclematrix";
	}
}
