package com.example.Salary.service.Controller;

import com.example.Salary.service.Entity.Salary_Data;
import com.example.Salary.service.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @PostMapping("/add")
    public ResponseEntity<String> addSalary(@RequestBody Salary_Data salary){
        String savedData=salaryService.addSalary(salary);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }
    @GetMapping("/getSalaryById")
    public Double getSalaryById(@RequestParam Long emp_Id){
        return salaryService.getSalaryById(emp_Id);
    }
    @PutMapping("/update")
    public String updateSalary(@RequestParam Long emp_Id ,@RequestParam Double salary){
        return salaryService.updateSalary(emp_Id,salary);

    }
    @PutMapping("/update/by-percent")
    public String updateSalaryByPercent(@RequestParam Long emp_Id ,@RequestParam Double percent){
        return salaryService.updateSalaryByPercent(emp_Id,percent);

    }

}
