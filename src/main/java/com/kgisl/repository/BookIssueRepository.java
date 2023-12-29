package com.kgisl.repository;

import com.kgisl.model.BookIssues;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.StandardEmitterMBean;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookIssueRepository extends JpaRepository<BookIssues,Long> {

    BookIssues getByIssueId(Long issueId);
    List<BookIssues> getByStatus(String issued);
    List<BookIssues> getByIssueDate(LocalDate issueDate);
    List<BookIssues> getByIssueDateAndStatus(LocalDate issueDate,String status);


}
