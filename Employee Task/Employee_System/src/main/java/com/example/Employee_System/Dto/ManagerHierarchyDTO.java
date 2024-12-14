package com.example.Employee_System.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerHierarchyDTO {
    private Long managerId;
    private String managerName;
    private List<EmployeeDTO> employees;

}
