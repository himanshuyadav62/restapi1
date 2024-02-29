package com.example.restapi1.dao;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi1.entity.Student; 


public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Student findById(int id); 
    public List<Student>  findByFirstName(String firstName);
}
