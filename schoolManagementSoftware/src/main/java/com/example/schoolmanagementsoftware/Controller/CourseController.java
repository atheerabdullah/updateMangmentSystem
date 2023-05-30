package com.example.schoolmanagementsoftware.Controller;


import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/Course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAllCourse")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> CourseList = courseService.getAllCourse();
        return ResponseEntity.status(200).body(CourseList);

    }

    // we can use the parameter as dto instead of cores
    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("The course added");
    }


    @PostMapping("/{teacherId}/courses/{Course_id}")
    public ResponseEntity addCourseToTeacher(@PathVariable Integer teacherId, @PathVariable Integer Course_id) {
        courseService.assignCourseToTeacher(teacherId, Course_id);
        return ResponseEntity.status(200).body("assigned sucssufuly");
    }

    @GetMapping("/course/{id}/teacher")
    public String getTeacherNameForCourse(@PathVariable Integer id) {
        return courseService.getTeacherNameForCourse(id);
    }
}
