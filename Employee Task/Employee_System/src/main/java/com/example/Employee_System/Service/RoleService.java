package com.example.Employee_System.Service;

import com.example.Employee_System.Entity.Role;
import com.example.Employee_System.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public String addRole(Role role) {
        int rows = roleRepository.addRole(role);
        if (rows > 0) {
            return "Role added successfully!";
        } else {
            return "Failed to add Role.";
        }
    }
}
