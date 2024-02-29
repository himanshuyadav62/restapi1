package com.example.restapi1.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi1.entity.School;

public interface SchoolRepository extends JpaRepository<School,Integer>{
    
}
