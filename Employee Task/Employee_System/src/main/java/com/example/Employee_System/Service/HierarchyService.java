package com.example.Employee_System.Service;

import com.example.Employee_System.Dto.ManagerHierarchyDTO;
import com.example.Employee_System.Repository.HierarchyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HierarchyService {

    private final HierarchyRepository hierarchyRepository;

    // Constructor
    public HierarchyService(HierarchyRepository hierarchyRepository) {
        this.hierarchyRepository = hierarchyRepository;
    }

    // Method to get hierarchy for all managers
    public List<ManagerHierarchyDTO> getHierarchyForAllManagers() {
        return hierarchyRepository.getHierarchyForAllManagers();
    }
}
