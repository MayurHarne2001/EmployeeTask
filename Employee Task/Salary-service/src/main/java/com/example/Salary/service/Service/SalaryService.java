package com.example.Salary.service.Service;

import com.example.Salary.service.Entity.Salary_Data;
import com.example.Salary.service.Repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    public String addSalary(Salary_Data salary){
    int rows=salaryRepository.addSalary(salary);
    if(rows>0){
        return "salary added Successfully";
    }
    else{
        return "Unable to add Salary for the specific Employee";
    }

    }
    public Double getSalaryById(Long emp_Id){
        return salaryRepository.getSalaryById(emp_Id);
    }

    public String updateSalary(Long emp_Id,Double salary){

        int rows= salaryRepository.updateSalary(emp_Id,salary);
        if(rows>0){
            return "Salary updated Successfully";
        }
        else{
            return "Salary not updated";
        }
    }
    public String updateSalaryByPercent(Long emp_Id,Double percent){

        Double currentSalary=salaryRepository.getCurrentSalary(emp_Id);
        Double newSalary=currentSalary+currentSalary*percent/100;
        int rows= salaryRepository.updateSalary(emp_Id,newSalary);
        if(rows>0){
            return "Salary updated Successfully";
        }
        else{
            return "Salary not updated";
        }
    }
}
