package com.musclematrix.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.musclematrix.domain.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
	//강사 id와 일치하는 모든 약력을 찾음
	@Query("SELECT h FROM History h WHERE h.teacher.teacher_id = :teacherId")
	List<History> findAllByTeacherId(@Param("teacherId") Long teacherId);

	//강사 id와 일치하는 약력들을 모두 삭제
	@Modifying
	@Transactional
	@Query("DELETE FROM History h WHERE h.teacher.teacher_id = :teacherId")
	void deleteByTeacherId(Long teacherId);

}