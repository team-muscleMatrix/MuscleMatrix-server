package com.musclematrix.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.musclematrix.domain.History;

public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query("SELECT h FROM History h WHERE h.teacher.teacher_id = :teacherId")
    List<History> findAllByTeacherId(@Param("teacherId") Long teacherId);
}