package com.example.restapi1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi1.dto.StudentDto;
import com.example.restapi1.dto.StudentResponseDto;
import com.example.restapi1.service.StudentService;

@RestController
public class StudentController {
    
    private final StudentService studentService; 
   
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto addStudent(@RequestBody StudentDto studentDto ){
       return this.studentService.saveStudent(studentDto);      
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent(){
        return this.studentService.findAllStudent(); 
    }

    @GetMapping("/student/{id}")
    public StudentResponseDto findStudentById(@PathVariable int id){
       
        return studentService.findStudentById(id); 
       
    }
    @GetMapping("/students/{name}")
    public List<StudentResponseDto> findStudentsByName(@PathVariable String name){
        return this.studentService.findStudentsByName(name); 
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentByID(@PathVariable int id){
         this.studentService.deleteStudentById(id); 
    }
}



/*  
    Data Transfer Object for student ( so we can exclude age in post)
    @PostMapping("/students")
    public Student addStudent(@RequestBody StudentDto studentDto){
        Student student = toStudent(studentDto);
        return  this.studentRepository.save(student); 
    }
*/