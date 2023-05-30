package com.example.schoolmanagementsoftware.Repositiry;

import com.example.schoolmanagementsoftware.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course , Integer> {

    Course findAllById(Integer id);
}
