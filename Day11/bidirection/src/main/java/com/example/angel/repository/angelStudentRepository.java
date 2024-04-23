package com.example.angel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angel.model.angelStudent;



@Repository
public interface angelStudentRepository extends JpaRepository<angelStudent,Integer>{
    
}
