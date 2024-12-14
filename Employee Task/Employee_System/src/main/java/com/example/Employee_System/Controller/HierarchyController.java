package com.example.Employee_System.Controller;

import com.example.Employee_System.Dto.ManagerHierarchyDTO;
import com.example.Employee_System.Service.HierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hierarchy")
public class HierarchyController {

    @Autowired
    private HierarchyService hierarchyService;

    @GetMapping
    public List<ManagerHierarchyDTO> getHierarchy() {
        return hierarchyService. getHierarchyForAllManagers();
    }
}
