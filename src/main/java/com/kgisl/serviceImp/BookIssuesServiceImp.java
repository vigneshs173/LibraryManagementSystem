package com.kgisl.serviceImp;

import com.kgisl.exceptionHandling.*;
import com.kgisl.repository.StudentRepository;
import com.kgisl.request.IssueRequest;
import com.kgisl.request.ReturnRequest;
import com.kgisl.model.BookIssues;
import com.kgisl.model.LibraryBooks;
import com.kgisl.model.Student;
import com.kgisl.repository.BookIssueRepository;
import com.kgisl.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class BookIssuesServiceImp implements BookIssueService {

    @Autowired
    StudentServiceImp studentServiceImp;

    @Autowired
    LibraryBooksServiceImp libraryBooksServiceImp;

    @Autowired
    BookIssueRepository bookIssuesRepository;

    @Autowired
    StudentRepository studentRepository;

    public BookIssues issueBook(BookIssues issue) {
        return bookIssuesRepository.save(issue);
    }

    public BookIssues updateIssue(BookIssues issue) {
        return bookIssuesRepository.save(issue);
    }

    public BookIssues getByIssueId(Long issueId) {
        return bookIssuesRepository.getByIssueId(issueId);
    }

    public List<BookIssues> getAllIssuedBooks() {
        return bookIssuesRepository.getByStatus("Issued");
    }

    public List<BookIssues> getAllReturnedBooks() {
        return bookIssuesRepository.getByStatus("Returned");
    }

    public List<BookIssues> getIssuedBooksByDate(LocalDate issueDate) {
        return bookIssuesRepository.getByIssueDate(issueDate);
    }

    public List<BookIssues> getIssuedBooksByDateAndStatus(LocalDate issueDate) {
        return bookIssuesRepository.getByIssueDateAndStatus(issueDate,"Issued");
    }

    public BookIssues issueBookRequest(IssueRequest issueRequest) {

        if (issueRequest.getStudentId() == null || issueRequest.getBookId() == null) {
            throw new InvalidStudentIdAndBookId("Invalid Student Id or Book Id");
        }

        Student student = studentRepository.getByStudentId(issueRequest.getStudentId());
        if (student == null) {
            throw new StudentNotFoundException("Student is not exist in database");
        }

        LibraryBooks book = libraryBooksServiceImp.getBookById(issueRequest.getBookId());
        if (book == null) {
            throw new BookNotFoundException("Book is not exist in database");
        }

        if (book.getAvailableCopies() > 0) {

            BookIssues issue = new BookIssues();
            issue.setIssueDate(LocalDate.now());
            issue.setDueDate(LocalDate.now().plusDays(15));
            issue.setStatus("Issued");
            issue.setStudent(student);
            issue.setBook(book);

            book.setAvailableCopies(book.getAvailableCopies() - 1);
            libraryBooksServiceImp.updateBook(book);

            return issueBook(issue);
        } else {
            throw new BookOutOfStackException("Book is out of stack.");
        }


    }

    public BookIssues returnBookRequest(ReturnRequest returnRequest) {
        if (returnRequest.getIssueId() == null)
            throw new InvalidIssueIdException("Invalid IssueId.");

        BookIssues issue = getByIssueId(returnRequest.getIssueId());

        if(issue == null)
            throw new IssuesNotFoundException("Book Issue not found in database.");

        if (issue.getStatus().equals("Issued")) {
            issue.setReturnDate(LocalDate.now());
            issue.setStatus("Returned");
            long delayDays = ChronoUnit.DAYS.between(issue.getDueDate(), LocalDate.now());
            if (delayDays > 0) {
                double bookPrice = issue.getBook().getPrice();
                double fineAmount = ((int) delayDays / 100.00) * bookPrice;
                issue.setFineAmount(fineAmount);
            }

            LibraryBooks book = libraryBooksServiceImp.getBookById(issue.getBook().getBookId());
            book.setAvailableCopies(book.getAvailableCopies() + 1);

            //update
            libraryBooksServiceImp.updateBook(book);
            return updateIssue(issue);
        }
        else
            throw new IssueAlreadyReturnedException("This Issue was already returned.");
    }
}
