package com.kgisl.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kgisl.model.BookIssues;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private boolean success;
    private String message;
    private StudentDTO studentDTO;
    private List<StudentDTO> studentList;
    private BookIssues bookIssues;
    private List<BookIssues> bookIssuesList;

    //private List<StudentDTO> studentDTOs;
    //private List<Student> studentListi;

}