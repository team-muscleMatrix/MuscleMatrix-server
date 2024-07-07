package com.musclematrix.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
		//모든 강사 정보를 가져옴
    @Query("SELECT t FROM Teacher t WHERE t.teacher_STATUS = 1")
    List<Teacher> findAllByStatus();
    
    //프로필이미지 파일명으로 강사를 찾기
    @Query("SELECT t FROM Teacher t WHERE t.teacher_profile = :teacherProfile")
    Teacher findByTeacherProfile(@Param("teacherProfile") String teacherProfile);
    
    //강사 이름으로 검색하는 함수
  	@Query("SELECT t FROM Teacher t WHERE t.teacher_name LIKE %:name%")
    List<Teacher> findAllByName(String name);
  	
  	//id를 받아서 행을 아예 삭제
  	@Transactional
  	@Modifying
  	@Query("DELETE FROM Teacher t WHERE t.teacher_id = :teacherId")
  	void deleteById(Long teacherId);
}