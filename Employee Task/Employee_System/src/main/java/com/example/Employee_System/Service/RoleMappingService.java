package com.example.Employee_System.Service;

import com.example.Employee_System.Repository.RoleMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleMappingService {

    @Autowired
    private RoleMappingRepository roleMappingRepository;

    public String updateRoleForEmployee(Long emp_Id, Long role_Id) {
        int rowsUpdated = roleMappingRepository.updateRoleMapping(emp_Id, role_Id);
        if (rowsUpdated > 0) {
            return "Role updated successfully for employee with ID: " + emp_Id;
        } else {
            return "Failed to update role for employee with ID: " + emp_Id;
        }
    }
}
