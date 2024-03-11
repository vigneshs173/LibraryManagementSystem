package com.kgisl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SampleEntity {
    @Id
    private Long test1;
    private String test2;
    private String test3;
    private Long test4;
    private String test5;
    private String test6;
    private Long test7;
    private String test8;
    private String test9;
    private Long test10;
    private String test11;
    private String test12;
}
