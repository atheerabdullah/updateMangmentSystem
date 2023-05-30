package com.example.schoolmanagementsoftware.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherDTO {



    private String name;
    private Integer age;
    private String email;
    private Integer salary;

    public TeacherDTO() {

    }
}
