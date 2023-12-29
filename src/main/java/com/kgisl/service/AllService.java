package com.kgisl.service;

import com.kgisl.model.BookIssues;
import com.kgisl.model.LibraryBooks;
import com.kgisl.model.Student;

public interface AllService {
    void issueBook(BookIssues issue);
    void updateBook(LibraryBooks book);
    LibraryBooks getBookById(Long bookId);

    Student getStudentById(Long studentId);
}
