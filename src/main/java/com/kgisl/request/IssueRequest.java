package com.kgisl.request;

import lombok.Data;

@Data
public class IssueRequest {
    private Long studentId;
    private Long bookId;
}