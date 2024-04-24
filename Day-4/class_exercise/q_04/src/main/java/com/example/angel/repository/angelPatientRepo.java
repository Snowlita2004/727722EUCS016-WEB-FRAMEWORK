package com.example.angel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.q_04.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}