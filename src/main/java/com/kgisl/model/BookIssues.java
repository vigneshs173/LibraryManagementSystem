package com.kgisl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class BookIssues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
    private double fineAmount;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "bookId")
    private LibraryBooks book;


}