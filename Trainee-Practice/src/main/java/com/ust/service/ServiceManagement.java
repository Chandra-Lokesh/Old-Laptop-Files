package com.ust.service;

import com.ust.model.College;
import com.ust.model.Student;
import com.ust.repository.CollegeRepo;
import com.ust.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceManagement {

    @Autowired
    CollegeRepo collegeRepo;

    @Autowired
    StudentRepo studentRepo;

    public College createCollege(College college){
        return collegeRepo.save(college);
    }

    public Student createStudent(int collegeId, Student student){
        College college = collegeRepo.findById(collegeId).orElseThrow(() -> new RuntimeException("college with id" + collegeId + " not found!!!"));
        student.setCollege(college);
        college.getStudentList().add(student);
        Student stu = studentRepo.save(student);
        collegeRepo.save(college);
        return stu;
    }

    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public List<College> getAllColleges(){
        return collegeRepo.findAll();
    }

}
