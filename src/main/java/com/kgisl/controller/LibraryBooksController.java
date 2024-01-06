package com.kgisl.controller;

import com.kgisl.model.BookIssues;
import com.kgisl.model.LibraryBooks;
import com.kgisl.serviceImp.LibraryBooksServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("library")
public class LibraryBooksController {
    @Autowired
    LibraryBooksServiceImp libraryBooksServiceImp;

    @PostMapping("/insert")
    LibraryBooks insert(@RequestBody LibraryBooks libraryBooks) {
        return libraryBooksServiceImp.addBook(libraryBooks);
    }

    @GetMapping("/getAll")
    List<LibraryBooks> getAll() {
        return libraryBooksServiceImp.getAllBooks();
    }



}
