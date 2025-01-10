package com.ust.service;

import com.ust.model.Employee;
import com.ust.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    Repository repository;

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }

}
