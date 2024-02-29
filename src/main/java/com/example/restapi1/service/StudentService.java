package com.example.restapi1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.restapi1.dao.StudentRepository;
import com.example.restapi1.dto.StudentDto;
import com.example.restapi1.dto.StudentResponseDto;
import com.example.restapi1.entity.Student;
import com.example.restapi1.mapper.StudentMapper;

@Service
public class StudentService {
    private final StudentRepository studentRepository; 
    private final  StudentMapper studentMapper;
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    } 
    
    public StudentResponseDto saveStudent(StudentDto studentDto){
         Student student = studentMapper.toStudent(studentDto); 
        this.studentRepository.save(student); 
        return studentMapper.toStudentResponseDto(student); 
    }

    public List<StudentResponseDto> findAllStudent(){
            List<StudentResponseDto> list = new ArrayList<>();
            for(var i : this.studentRepository.findAll()){
                list.add(studentMapper.toStudentResponseDto(i));
            }
            return list; 
    }
    public StudentResponseDto findStudentById(int id){
        try {
            Student student = this.studentRepository.findById(id);
            return this.studentMapper.toStudentResponseDto(student);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return this.studentMapper.toStudentResponseDto(new Student()); 
    }

    public List<StudentResponseDto> findStudentsByName(String name){
        List<StudentResponseDto> students = new ArrayList<>(); 
        List<Student> list = this.studentRepository.findByFirstName(name); 
        for(var i : list){
        students.add(this.studentMapper.toStudentResponseDto(i));
        }
        return students; 
    }

    public void deleteStudentById(int id){
        this.studentRepository.deleteById(id);
    }
}
