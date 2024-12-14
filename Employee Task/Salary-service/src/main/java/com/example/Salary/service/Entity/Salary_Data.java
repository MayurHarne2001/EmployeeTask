package com.example.Salary.service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Salary_Data {

    @Id
    private Long emp_Id;
    private Double salary;


    public Long getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(Long emp_Id) {
        this.emp_Id = emp_Id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
