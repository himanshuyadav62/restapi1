package com.example.restapi1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity 
public class StudentProfile {
    @Id
    @GeneratedValue
    private int id ; 
    private String bio; 

    @OneToOne
    @JoinColumn(
        name = "studentId"
    )
    private Student student; 

    public StudentProfile(){

    }
    public StudentProfile(int id, String bio) {
        this.id = id;
        this.bio = bio;
    }
    
   
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    
}
