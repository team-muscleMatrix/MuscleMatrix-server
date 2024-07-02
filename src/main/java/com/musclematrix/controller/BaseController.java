package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaseController {

	//1. 모델에 값을 넣어주는 기능 (isLogin, member_id, member_profile, member_nickname)
	@ModelAttribute("isLogin")
	public String setLoginStatus(HttpSession session) {
		return session.getAttribute("member_id") == null ? "no" : "yes";
	}
	
//	@ModelAttribute("member_id")
//	public String setMember_id(HttpSession session) {
//		return String.valueOf(session.getAttribute("member_id"));
//	}
}
