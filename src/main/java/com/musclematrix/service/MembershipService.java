package com.musclematrix.service;

import org.springframework.stereotype.Service;

import com.musclematrix.domain.Membership;
import com.musclematrix.repository.MembershipRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {
	
	private final MembershipRepository membershipRepository;
	
	// 회원 저장
	@Transactional
	public Membership save(Membership member) {
		return membershipRepository.save(member);
	}
	
	// 회원의 존재 여부를 확인하는 메서드
  public int checkMembershipExists(String membership_email) {
      Membership membership = membershipRepository.findByMembershipEmail(membership_email);
      return (membership != null) ? 1 : 0;
  }
  
  // login 메서드
	public Membership findMemberByEmailAndPassword(String membership_email, String membership_password) {
		return membershipRepository.findByEmailAndPassword(membership_email, membership_password);
	}
	
	// 금일 가입자 메서드
	public int countToday() {
		return membershipRepository.countTodayRegistrations();
	}
	
	// 누적 가입자 메서드
	public int countTotal() {
		return membershipRepository.countTotalRegistrations();
	}
	
}
