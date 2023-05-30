package com.example.schoolmanagementsoftware.Service;


import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.DTO.TeacherDTO;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repositiry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {


    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Integer id) {
        Teacher updateTeacher = teacherRepository.findTeacherById(id);
        if (updateTeacher == null) {
            throw new ApiException("teacher not found");
        }
        updateTeacher.setName(teacher.getName());
        updateTeacher.setAge(teacher.getAge());
        updateTeacher.setEmail(teacher.getEmail());
        updateTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(updateTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public TeacherDTO getTeacherDetailsById(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher != null) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setName(teacher.getName());
            teacherDTO.setAge(teacher.getAge());
            teacherDTO.setEmail(teacher.getEmail());
            teacherDTO.setSalary(teacher.getSalary());
            return teacherDTO;
        } else {
            throw new ApiException("Teacher not found with ID: " + id);
        }
    }

}
