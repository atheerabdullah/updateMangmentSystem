package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.DTO.TeacherDTO;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/Teacher")
@AllArgsConstructor

public class TeacherController {


    private final TeacherService teacherService;

    @GetMapping("/getAllTeacher")
    public ResponseEntity getAllCustomers(){
        List<Teacher> teachers=teacherService.getAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/addTeacher")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiException("teacher added"));
    }

    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("teacher Updated");
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");

    }
    @GetMapping("/getTeacherDetails/{id}")
    public ResponseEntity<TeacherDTO> getTeacherDetails(@PathVariable Integer id) {
            TeacherDTO teacherDTO = teacherService.getTeacherDetailsById(id);
            return ResponseEntity.ok().body(teacherDTO);
        }

    }
