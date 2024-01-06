package com.kgisl.service;

import com.kgisl.exceptionHandling.StudentNotActiveInDatabase;
import com.kgisl.exceptionHandling.StudentNotFoundException;
import com.kgisl.model.Student;
import com.kgisl.repository.StudentRepository;
import com.kgisl.response.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {


    public StudentDTO studentToStudentDTO(Student student);

    public StudentDTO getByStudentId(Long studentId);

    public StudentDTO insertStudent(Student student);


    public Student deleteStudent(Long studentId);


    public List<StudentDTO> getAllStudents();

    public List<StudentDTO> getAllStudentsDemoo();

}


