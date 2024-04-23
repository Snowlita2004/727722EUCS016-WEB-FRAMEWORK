package com.example.angel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.angel.model.angelStudent;
import com.example.angel.model.angelStudentInfo;
import com.example.angel.repository.angelStudentInfoRepository;
import com.example.angel.repository.angelStudentRepository;

@Service
public class angelStudentService {
    public angelStudentRepository studentRepository;
    public angelStudentInfoRepository studentInfoRepository;
    public angelStudentService(angelStudentRepository studentRepository,angelStudentInfoRepository studentInfoRepository)
    {
        this.studentRepository = studentRepository;
        this.studentInfoRepository = studentInfoRepository;
    }
    public angelStudent saveStudent(angelStudent student)
    {
        return studentRepository.save(student);
    }
    public angelStudentInfo saveStudentInfo(angelStudentInfo studentInfo)
    {
        return studentInfoRepository.save(studentInfo);
    }
    public List<angelStudent> getStudents()
    {
        return studentRepository.findAll();
    }
}
