package com.example.restapi1.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {
    @Id
    @GeneratedValue
    private int id; 
    private String name;
    
    @OneToMany(
        mappedBy = "school" 
    )
    @JsonManagedReference
    List<Student> students; 

    // constructor  
    public School() { 
    }

    public School(int id, String name) {
        this.id = id;
        this.name = name;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    } 

    
}
