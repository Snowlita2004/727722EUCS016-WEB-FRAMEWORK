package com.example.class_exercise_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercise_2.model.angelStudent;
import com.example.class_exercise_2.service.angelStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class angelStudentController {

     @Autowired
     public angelStudentService studentService;

     @GetMapping("/api/student")
     public ResponseEntity<List<angelStudent>> getDetails() {
          List<angelStudent> list = studentService.getAll();
          if (list.isEmpty()) {
               return new ResponseEntity<List<angelStudent>>(list, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<angelStudent>>(list, HttpStatus.OK);

     }

     @PostMapping("/api/student")
     public ResponseEntity<angelStudent> postMethodName(@RequestBody angelStudent student) {

          angelStudent postData = studentService.post(student);
          return new ResponseEntity<>(postData, HttpStatus.OK);
     }

     @GetMapping("/api/student/sort/{field}")
     public ResponseEntity<List<angelStudent>> sortedDetails(@PathVariable String field) {
          List<angelStudent> list = studentService.sortedDetails(field);
          if (list.isEmpty()) {
               return new ResponseEntity<List<angelStudent>>(list, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<angelStudent>>(list, HttpStatus.OK);

     }
}
