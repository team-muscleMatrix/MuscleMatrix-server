package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaseController {

	//1. 모델에 값을 넣어주는 기능 (isLogin, membership_email)
	@ModelAttribute("isLogin")
	public String setLoginStatus(HttpSession session) {
		return session.getAttribute("membership_email") == null ? "no" : "yes";
	}
	
//	@ModelAttribute("member_id")
//	public String setMember_id(HttpSession session) {
//		return String.valueOf(session.getAttribute("member_id"));
//	}
}
