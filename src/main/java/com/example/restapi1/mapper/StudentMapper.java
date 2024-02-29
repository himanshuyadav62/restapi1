package com.example.restapi1.mapper;

import org.springframework.stereotype.Service;

import com.example.restapi1.dto.StudentDto;
import com.example.restapi1.dto.StudentResponseDto;
import com.example.restapi1.entity.School;
import com.example.restapi1.entity.Student;

@Service
public class StudentMapper {
      public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
            student.getFirstName(), student.getLastName(), student.getEmail()); 
    }

    public Student toStudent(StudentDto dto){
        Student student = new Student(); 
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School(); 
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;  
    }
}
