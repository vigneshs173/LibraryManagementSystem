package com.kgisl.repository;

import com.kgisl.model.LibraryBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBooksRepository extends JpaRepository<LibraryBooks,Long> {

    LibraryBooks getByBookId(Long bookId);
}

