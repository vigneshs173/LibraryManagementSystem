package com.kgisl.controller;

import com.kgisl.request.ReturnRequest;
import com.kgisl.model.BookIssues;
import com.kgisl.request.IssueRequest;
import com.kgisl.response.Response;
import com.kgisl.serviceImp.BookIssuesServiceImp;
import com.kgisl.serviceImp.LibraryBooksServiceImp;
import com.kgisl.serviceImp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book-issue")
public class BookIssuesController {

    @Autowired
    private BookIssuesServiceImp bookIssuesServiceImp;

    @Autowired
    private StudentServiceImp studentServiceImp;

    @Autowired
    private LibraryBooksServiceImp libraryBooksServiceImp;

    @PostMapping("/issue")
    public ResponseEntity<Response> issueBook(@RequestBody IssueRequest issueRequest) {
            return new ResponseEntity(new Response(true,"Book Issued successfully.",null,null,bookIssuesServiceImp.issueBookRequest(issueRequest),null),HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<Response> returnBook(@RequestBody ReturnRequest returnRequest) {
            return new ResponseEntity(new Response(true,"Book Returned Successfully", null,null,  bookIssuesServiceImp.returnBookRequest(returnRequest),null),HttpStatus.OK);
    }

    @GetMapping("/issuedBooks")
    public ResponseEntity<Response> getAllIssuedBooks() {

        return new ResponseEntity(new Response(true,"All Issued Book list",null,null,null,bookIssuesServiceImp.getAllIssuedBooks()),HttpStatus.OK);
        //return bookIssuesServiceImp.getAllIssuedBooks();
    }

    @GetMapping("/returnedBooks")
    public List<BookIssues> getAllReturnedBooks() {
        return bookIssuesServiceImp.getAllReturnedBooks();
    }

    @GetMapping("/issuedBooksByDate/{issueDate}")
    public List<BookIssues> getIssuedBooksByDate(@PathVariable LocalDate issueDate) {
        return bookIssuesServiceImp.getIssuedBooksByDate(issueDate);
    }

    @GetMapping("/issuedBooksByDateAndIssued/{issueDate}")
    public List<BookIssues> getIssuedBooksByDateAndStatus(@PathVariable LocalDate issueDate) {
        return bookIssuesServiceImp.getIssuedBooksByDateAndStatus(issueDate);
    }

}
