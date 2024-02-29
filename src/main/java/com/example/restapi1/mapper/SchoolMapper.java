package com.example.restapi1.mapper;

import org.springframework.stereotype.Service;

import com.example.restapi1.dto.SchoolDto;
import com.example.restapi1.entity.School;

@Service
public class SchoolMapper {
   
     public SchoolDto toSchoolDto(School school){
        return  new SchoolDto(school.getName()); 

    }
    public School toSchool(SchoolDto schoolDto){
        var school =  new School(); 
        school.setName(schoolDto.name());
        return school;         
    }
}
