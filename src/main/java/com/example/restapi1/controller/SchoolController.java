package com.example.restapi1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi1.dto.SchoolDto;
import com.example.restapi1.entity.School;
import com.example.restapi1.service.SchoolService;

@RestController
public class SchoolController {
    
    private SchoolService schoolService; 
    
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService; 
    }
    
    @GetMapping("/schoolnames")
    public List<SchoolDto> getSchoolNames(){
        return this.schoolService.findAllSchools(); 
    }
    
    @PostMapping("/school")
    public SchoolDto addSchool(@RequestBody School school){
        return this.schoolService.addSchool(school);
    }
}
