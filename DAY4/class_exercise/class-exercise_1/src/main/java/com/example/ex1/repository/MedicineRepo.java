package com.example.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex1.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine,Integer>
{
    
}
