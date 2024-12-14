package com.example.Employee_System.Service;


import com.example.Employee_System.Entity.ManagerForEmployee;
import com.example.Employee_System.Repository.ManagerForEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerForEmpService {

    @Autowired
    private ManagerForEmpRepository repository;

    public String assignManager(ManagerForEmployee managerForEmployee) {
        int rows = repository.addManagerForEmployee(managerForEmployee);
        return rows > 0 ? "Manager assigned successfully!" : "Failed to assign manager.";
    }
}
