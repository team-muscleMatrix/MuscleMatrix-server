package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.musclematrix.domain.Membership;
import com.musclematrix.service.MembershipService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final MembershipService membershipService;

	@GetMapping("/login/login/{exist}")
	public String viewLogin(@PathVariable("exist") int exist, Model model) {
		model.addAttribute("exist", exist);
		return "/login/login";
	}

	@PostMapping("/login/login")
	public String goLogin(HttpServletRequest request, Membership loginMember) {
		Membership realLoginMember = membershipService.findMemberByEmailAndPassword(loginMember.getMembership_email(),
				loginMember.getMembership_password());
		if (realLoginMember != null) {
			// 로그인이 됬다면 로그인 정보를 세션에 담는다.
			HttpSession session = request.getSession();
			session.setAttribute("membership_email", realLoginMember.getMembership_email());
			return "redirect:/";
		} else {
			return "redirect:/login/login/2";
		}

	}

	@GetMapping("/logout")
	public String goLogout(HttpSession session) {
		String accessToken = String.valueOf(session.getAttribute("accessToken"));

		// 로그아웃 진행 : 세션에서 관련된 모든 정보 지움
		session.removeAttribute("membership_email");
		session.removeAttribute("isLogin"); // 로그인했다는 정보도 지움

		return "redirect:/";
	}
}
