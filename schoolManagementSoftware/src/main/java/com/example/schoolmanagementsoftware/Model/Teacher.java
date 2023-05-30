package com.example.schoolmanagementsoftware.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor // > with primary key
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // > we need the auto generate only on main class
    private Integer id;

    private String name;
    private Integer age;
    private String email;
    private Integer salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL , mappedBy = "teacher")
    private Set<Course> courses;

}