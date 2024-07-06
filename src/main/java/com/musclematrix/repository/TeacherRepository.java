package com.musclematrix.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.musclematrix.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT t FROM Teacher t WHERE t.teacher_STATUS = 1")
    List<Teacher> findAllByStatus();
}