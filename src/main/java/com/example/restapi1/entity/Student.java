package com.example.restapi1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
    @Id @GeneratedValue
    private int id; 
    private String firstName; 
    private String lastName; 
    @Column(unique = true)
    private String email; 
    private int age;

    @OneToOne(mappedBy = "student" ,cascade = CascadeType.ALL)
    private StudentProfile studentProfile; 

    @ManyToOne
    @JoinColumn(
        name = "studentId"
    )
    @JsonBackReference
    private School school; 

    public Student() {
    } 
    
    
    public Student(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }


    public StudentProfile getStudentProfile() {
        return studentProfile;
    }


    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }


    public School getSchool() {
        return school;
    }


    public void setSchool(School school) {
        this.school = school;
    }


    public int getId() { 
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    } 
    

}
