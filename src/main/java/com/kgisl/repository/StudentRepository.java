package com.kgisl.repository;

import com.kgisl.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student getByStudentId(Long studentId);

    List<Student> getByIsActive(int i);
}
