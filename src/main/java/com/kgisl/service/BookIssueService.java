package com.kgisl.service;

import com.kgisl.exceptionHandling.*;
import com.kgisl.model.BookIssues;
import com.kgisl.model.LibraryBooks;
import com.kgisl.model.Student;
import com.kgisl.request.IssueRequest;
import com.kgisl.request.ReturnRequest;

import java.time.LocalDate;
import java.util.List;

public interface BookIssueService {


    public BookIssues issueBook(BookIssues issue);

    public BookIssues updateIssue(BookIssues issue);
    public BookIssues getByIssueId(Long issueId);

    public List<BookIssues> getAllIssuedBooks();

    public List<BookIssues> getAllReturnedBooks();
    public List<BookIssues> getIssuedBooksByDate(LocalDate issueDate);

    public List<BookIssues> getIssuedBooksByDateAndStatus(LocalDate issueDate);

    public BookIssues issueBookRequest(IssueRequest issueRequest);

    public BookIssues returnBookRequest(ReturnRequest returnRequest);
}
