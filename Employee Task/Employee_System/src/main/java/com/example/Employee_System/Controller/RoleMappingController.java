package com.example.Employee_System.Controller;


import com.example.Employee_System.Service.RoleMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role-mapping")
public class RoleMappingController {

    @Autowired
    private RoleMappingService roleMappingService;

    @PostMapping("/update-role")
    public String updateRoleForEmployee(@RequestParam Long empId, @RequestParam Long roleId) {
        return roleMappingService.updateRoleForEmployee(empId, roleId);
    }
}
