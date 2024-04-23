package com.examly.class_exercise_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.examly.class_exercise_2.model.angelCourse;
import com.examly.class_exercise_2.service.angelCourseService;

@RestController
public class angelCourseController {

     @Autowired
     public angelCourseService CourseService;

     @PostMapping("/api/course")
     public ResponseEntity<angelCourse> postMethodName(@RequestBody angelCourse entity) {

          angelCourse inst = CourseService.SaveEntity(entity);

          return new ResponseEntity<angelCourse>(inst, HttpStatus.CREATED);

     }

     @GetMapping("/api/course")
     public ResponseEntity<List<angelCourse>> getMethodName() {

          List<angelCourse> show = CourseService.getDetails();
          if (!show.isEmpty()) {
               return new ResponseEntity<List<angelCourse>>(show, HttpStatus.OK);
          } else {
               return new ResponseEntity<List<angelCourse>>(show, HttpStatus.NOT_FOUND);
          }
     }

     @GetMapping("api/course/{courseName}")
     public List<angelCourse> custom(@PathVariable String courseName) {
          return CourseService.findByCourseName(courseName);

     }
}