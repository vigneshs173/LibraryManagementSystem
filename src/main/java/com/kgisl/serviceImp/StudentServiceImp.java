package com.kgisl.serviceImp;

import com.kgisl.exceptionHandling.StudentNotActiveInDatabase;
import com.kgisl.exceptionHandling.StudentNotFoundException;
import com.kgisl.request.AddBookAndStudent;
import com.kgisl.model.Student;
import com.kgisl.repository.StudentRepository;
import com.kgisl.response.StudentDTO;
import com.kgisl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDTO studentToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    public StudentDTO getByStudentId(Long studentId) {

        Student student = studentRepository.getByStudentId(studentId);
        if(student == null)
            throw new StudentNotFoundException("STUDENT NOT EXIST");
        else if(student.getIsActive() == 0)
            throw new StudentNotActiveInDatabase("STUDENT NOT ACTIVE");
        else
            return studentToStudentDTO(student);



    }
    public StudentDTO insertStudent(Student student) {
        //Student student = addBookAndStudent.getStudent();
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

    public Student insert(Student student) {
        return studentRepository.save(student);
    }
}