package com.kgisl.controller;

import com.kgisl.request.AddBookAndStudent;
import com.kgisl.model.Student;
import com.kgisl.repository.StudentRepository;
import com.kgisl.response.Response;
import com.kgisl.response.StudentDTO;
import com.kgisl.serviceImp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImp studentServiceImp;

    @Autowired
    StudentRepository studentRepository;

//    @PostMapping("/insert")
//    public ResponseEntity<Response> insert(@RequestBody AddBookAndStudent addBookAndStudent) {
//        return new ResponseEntity(new Response(true,"Student inserted successfully.",studentServiceImp.insertStudent(addBookAndStudent),null,null,null), HttpStatus.OK);
//    }


    @PostMapping("/insert")
    public ResponseEntity<Response> insertS(@RequestBody Student student) {
        return new ResponseEntity(new Response(true,"Student inserted successfully.",studentServiceImp.insertStudent(student),null,null,null), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Response> getStudentById(@PathVariable Long studentId) {
        //return studentServiceImp.getByStudentId(studentId);
        return new ResponseEntity(new Response(true,"Student Details.",studentServiceImp.getByStudentId(studentId),null,null,null), HttpStatus.OK);
    }


    @PostMapping("/studentParam")
    public ResponseEntity<Response> param(@RequestParam Long studentId,@RequestParam String firstName, @RequestParam String email) {

        Student student = new Student();
        student.setStudentId(studentId);
        student.setFirstName(firstName);
        student.setEmail(email);
        return new ResponseEntity(new Response(true,"Student inserted successfully.",studentServiceImp.insertStudent(student),null,null,null), HttpStatus.OK);
    }


    @PostMapping("/studentHeader")
    public Student header(@RequestHeader String firstName, @RequestHeader String email) {
        //return studentServiceImp.getByStudentId(studentId);
        Student student = new Student();
        student.setFirstName(firstName);
        student.setEmail(email);

        return studentServiceImp.insert(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<StudentDTO> getAllStudents() {
        return new ResponseEntity(new Response(true,"List of all students.",null,studentServiceImp.getAllStudents(),null,null), HttpStatus.OK);
    }



    @PutMapping("/deleteStudent/{studentId}")
    public Student deleteByStudentId(@PathVariable Long studentId) {
        return studentServiceImp.deleteStudent(studentId);
    }
}
