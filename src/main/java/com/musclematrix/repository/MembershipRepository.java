package com.musclematrix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.musclematrix.domain.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
  
	//금일 가입자 수를 세는 JPQL 쿼리
	@Query("SELECT COUNT(m) FROM Membership m WHERE m.created_date >= CURRENT_DATE")
	int countTodayRegistrations();
	
	//누적 가입자 수를 세는 JPQL 쿼리
	@Query("SELECT COUNT(m) FROM Membership m")
	int countTotalRegistrations();
	
  // membership_email을 통해 회원을 조회하는 쿼리
  @Query("SELECT m FROM Membership m WHERE m.membership_email = :membershipEmail")
  Membership findByMembershipEmail(@Param("membershipEmail") String membershipEmail);
  
  // membership_email과 membership_password를 통해 회원 조회 쿼리
  @Query("SELECT m FROM Membership m WHERE m.membership_email = :membershipEmail AND m.membership_password = :membershipPassword")
  Membership findByEmailAndPassword(@Param("membershipEmail") String membershipEmail, @Param("membershipPassword") String membershipPassword);
}
