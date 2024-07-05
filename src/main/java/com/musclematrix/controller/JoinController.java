package com.musclematrix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.musclematrix.domain.Membership;
import com.musclematrix.service.MembershipService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinController {
	
	private final MembershipService membershipService;
	
	@GetMapping("/join/join")
	public String viewJoin() {
		return "/join/join";
	}
	
	@PostMapping("/join/join")
	public String enterJoin(Membership member) {
		
		// 현재 가입하려던 아이디가 이미 가입한 아이디라면 로그인 페이지로 이동
		String member_email = member.getMembership_email();
		int exist = membershipService.checkMembershipExists(member_email);
		if(exist == 1) {
			return "redirect:/login/login/" + exist;
		}
		else {
			// 그게 아니라면 회원가입 성공하고 로그인 페이지로 이동
			membershipService.save(member);
			return "redirect:/login/login/" + exist;			
		}
	}
}
