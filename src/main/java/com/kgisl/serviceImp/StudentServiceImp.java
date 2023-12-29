package com.kgisl.serviceImp;

import com.kgisl.request.AddBookAndStudent;
import com.kgisl.model.Student;
import com.kgisl.repository.StudentRepository;
import com.kgisl.response.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp {

    @Autowired
    StudentRepository studentRepository;

    public StudentDTO studentToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    public Student getByStudentId(Long studentId) {
        return studentRepository.getByStudentId(studentId);
    }
    public StudentDTO insertStudent(AddBookAndStudent addBookAndStudent) {
        Student student = addBookAndStudent.getStudent();
        return studentToStudentDTO(studentRepository.save(student));
    }



    public Student deleteStudent(Long studentId) {

        Student student = studentRepository.getByStudentId(studentId);
        student.setIsActive(0);
        return studentRepository.save(student);
    }


    public List<StudentDTO> getAllStudents() {
        return studentRepository.getByIsActive(1).stream()
                .map(this::studentToStudentDTO)
                .toList();
    }
}