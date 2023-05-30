package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repositiry.CourseRepository;
import com.example.schoolmanagementsoftware.Repositiry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }


    public void addCourse(Course course) {
        courseRepository.save(course);
    }


    public void updateCourse(Course course, Integer id) {
        Course updateCourse = courseRepository.findAllById(id);
        if (updateCourse == null) {
            throw new ApiException("Course not found");
        }
        updateCourse.setName(course.getName());
        updateCourse.setTeacher(course.getTeacher());
        updateCourse.setId(course.getId());
        courseRepository.save(updateCourse);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findAllById(id);
        if (course == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    public void assignCourseToTeacher(Integer Course_id, Integer Teacher_id) {
        Course course = courseRepository.findAllById(Course_id);
        Teacher teacher = teacherRepository.findTeacherById(Teacher_id);

        if (Course_id == null || Teacher_id == null) {
            throw new ApiException(" id wrong , I cant assign course to teacher");
        }
        course.setTeacher(teacher);
        teacherRepository.save(teacher);
    }

    public String getTeacherNameForCourse(Integer courseId) {
        Course course = courseRepository.findAllById(courseId);

        if (course == null || course.getTeacher() == null) {
            throw new ApiException("course Id not found " + courseId);
        }
        return course.getTeacher().getName();
    }


}
