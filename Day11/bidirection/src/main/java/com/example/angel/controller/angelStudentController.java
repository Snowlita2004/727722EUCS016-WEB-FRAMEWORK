package com.example.angel.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.angel.model.angelStudent;
import com.example.angel.model.angelStudentInfo;
import com.example.angel.service.angelStudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class angelStudentController {
    public angelStudentService studentService;
    public angelStudentController(angelStudentService studentService)
    {
        this.studentService = studentService;
    }
    @PostMapping("/api/poststudent")
    public angelStudent postMethodName(@RequestBody angelStudent student) {
        return studentService.saveStudent(student);
    }
    @PostMapping("/api/poststudentinfo")
    public angelStudentInfo postMethodName(@RequestBody angelStudentInfo studentInfo) {
        return studentService.saveStudentInfo(studentInfo);
    }
    @GetMapping("/api/student")
    public List<angelStudent> getMethodName() {
        return studentService.getStudents();
    }
    
}