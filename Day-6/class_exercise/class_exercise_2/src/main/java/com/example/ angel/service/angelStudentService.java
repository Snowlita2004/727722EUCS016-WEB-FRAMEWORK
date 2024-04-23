package com.example.class_exercise_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.class_exercise_2.model.Student;
import com.example.class_exercise_2.repository.StudentRepo;

@Service
public class angelStudentService {

     @Autowired
     public angelStudentRepo studentRepo;

     public List<angelStudent> getAll() {
          return studentRepo.findAll();
     }

     public angelStudent post(angelStudent student) {
          return studentRepo.save(student);
     }

     public List<angelStudent> sortedDetails(String field) {
          return studentRepo.findAll(Sort.by(Sort.Direction.DESC, field));
     }
}
