package com.example.ex1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex1.model.Medicine;
import com.example.ex1.repository.MedicineRepo;

@Service
public class MedicineService {

    @Autowired
    public MedicineRepo medicineRepo;

    public Medicine saveMedicine(Medicine medicine)
    {
        return medicineRepo.save(medicine);
    }
    public List<Medicine> getMedicines()
    {
        return medicineRepo.findAll();
    }
    public Medicine getMedicine(int id)
    {
        return medicineRepo.findById(id).orElse(null);
    }
    
}
