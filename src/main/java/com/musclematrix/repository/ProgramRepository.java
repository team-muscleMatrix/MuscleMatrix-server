package com.musclematrix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.History;
import com.musclematrix.domain.Program;

public interface ProgramRepository extends JpaRepository<Program, Long>{
	//강사 id와 일치하는 모든 프로그램을 찾음
	@Query("SELECT p FROM Program p WHERE p.teacher.teacher_id = :teacherId")
  List<Program> findAllByTeacherId(@Param("teacherId") Long teacherId);
	
	//강사 id와 일치하는 프로그램들을 모두 삭제
	@Modifying
	@Transactional
	@Query("DELETE FROM Program p WHERE p.teacher.teacher_id = :teacherId")
	void deleteByTeacherId(Long teacherId);

}
