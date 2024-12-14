package com.example.Employee_System.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeWithSalary {
    private Long empId;
    private String name;
    private String phoneNo;
    private Double salary;

}
