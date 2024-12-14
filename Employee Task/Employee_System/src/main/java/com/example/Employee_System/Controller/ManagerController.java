package com.example.Employee_System.Controller;

import com.example.Employee_System.Entity.ManagerForEmployee;
import com.example.Employee_System.Service.ManagerForEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerForEmpService service;

    @PostMapping("/assign")
    public String assignManager(@RequestBody ManagerForEmployee managerForEmployee) {
        return service.assignManager(managerForEmployee);
    }
}
