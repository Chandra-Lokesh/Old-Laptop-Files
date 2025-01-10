package com.ust.controller;

import com.ust.model.College;
import com.ust.model.Student;
import com.ust.service.ServiceManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    ServiceManagement service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/colleges")
    public List<College> getAllColleges(){
        return service.getAllColleges();
    }

    @PostMapping("/addStudent/{id}")
    public Student addStudent(@PathVariable("id") int collegeId, @RequestBody Student student){
        return service.createStudent(collegeId, student);
    }

    @PostMapping("/addCollege")
    public College addStudent(@RequestBody College college){
        return service.createCollege(college);
    }
}
