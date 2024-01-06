package com.kgisl.serviceImp;

import com.kgisl.model.LibraryBooks;
import com.kgisl.repository.LibraryBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryBooksServiceImp {

    @Autowired
    private LibraryBooksRepository libraryBooksRepository;

    public LibraryBooks getBookById(Long bookId) {
        return libraryBooksRepository.getByBookId(bookId);
    }

    public void updateBook(LibraryBooks book) {
        libraryBooksRepository.save(book);
    }

    public LibraryBooks addBook(LibraryBooks libraryBooks) {
        return libraryBooksRepository.save(libraryBooks);
    }

    public List<LibraryBooks> getAllBooks() {
        return libraryBooksRepository.findAll();
    }

}
