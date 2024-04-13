package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.StudentModel;


public interface StudentRepository extends JpaRepository<StudentModel,Integer>{


}
