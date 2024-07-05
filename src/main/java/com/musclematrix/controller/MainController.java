package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musclematrix.service.MembershipService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController extends BaseController{
	
	private final MembershipService membershipService;

	@RequestMapping("/")
	public String viewMain(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		int todayCount = membershipService.countToday();
		int totalCount = membershipService.countTotal();
		
		model.addAttribute("todayCount", todayCount);
		model.addAttribute("totalCount", totalCount);

		if(model.getAttribute("isLogin") == "no") {
			log.info("로그인 안됨");
			return "/main/main";
		}
		else {
			log.info((String) model.getAttribute("isLogin"));
			return "/main/main";
		}
	}
	
}
