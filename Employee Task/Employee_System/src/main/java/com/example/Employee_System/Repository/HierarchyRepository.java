package com.example.Employee_System.Repository;

import com.example.Employee_System.Dto.EmployeeDTO;
import com.example.Employee_System.Dto.ManagerHierarchyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;


import java.util.HashMap;


@Repository
public class HierarchyRepository {

    private final JdbcTemplate jdbcTemplate;

    // Constructor
    public HierarchyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to fetch hierarchy for all managers
    public List<ManagerHierarchyDTO> getHierarchyForAllManagers() {
        String sql = """
            SELECT m.id AS manager_id,
                   e1.name AS manager_name,
                   e2.emp_id AS emp_id,
                   e2.name AS emp_name
            FROM manager_for_employee m
            JOIN role_mapping rm ON m.role_id = rm.id
            JOIN employee_data e1 ON rm.emp_id = e1.emp_id
            JOIN employee_data e2 ON m.emp_id = e2.emp_id
        """;

        List<ManagerHierarchyDTO> managerHierarchyList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Long managerId = rs.getLong("manager_id");
            String managerName = rs.getString("manager_name");
            Long empId = rs.getLong("emp_id");
            String empName = rs.getString("emp_name");

            return new ManagerHierarchyDTO(managerId, managerName, List.of(new EmployeeDTO(empId, empName)));
        });

        // Group employees under each manager
        Map<Long, ManagerHierarchyDTO> managerMap = new HashMap<>();
        for (ManagerHierarchyDTO dto : managerHierarchyList) {
            managerMap.computeIfAbsent(dto.getManagerId(), id -> new ManagerHierarchyDTO(
                    dto.getManagerId(),
                    dto.getManagerName(),
                    new ArrayList<>()
            )).getEmployees().add(dto.getEmployees().get(0));  // Adding employee to the manager's list
        }

        return new ArrayList<>(managerMap.values());
    }
}
