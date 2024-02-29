package com.example.restapi1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.restapi1.dao.SchoolRepository;
import com.example.restapi1.dto.SchoolDto;
import com.example.restapi1.entity.School;
import com.example.restapi1.mapper.SchoolMapper;

@Service
public class SchoolService {
    private final SchoolMapper schoolMapper; 
    private final SchoolRepository schoolRepository;
    
    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public List<SchoolDto> findAllSchools() {
         
        return schoolRepository.findAll()
                    .stream()
                    .map(schoolMapper::toSchoolDto)
                    .collect(Collectors.toList());
    }

    public SchoolDto addSchool(School school) {
        return this.schoolMapper.toSchoolDto(this.schoolRepository.save(school)); 
    } 

    
}
