package com.example.angel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angel.model.angelStudentInfo;

@Repository
public interface angelStudentInfoRepository extends JpaRepository<angelStudentInfo,Integer>{
    
}