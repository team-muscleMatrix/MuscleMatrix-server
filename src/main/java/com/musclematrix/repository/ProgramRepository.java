package com.musclematrix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.musclematrix.domain.History;
import com.musclematrix.domain.Program;

public interface ProgramRepository extends JpaRepository<Program, Long>{
	@Query("SELECT p FROM Program p WHERE p.teacher.teacher_id = :teacherId")
  List<Program> findAllByTeacherId(@Param("teacherId") Long teacherId);

}
