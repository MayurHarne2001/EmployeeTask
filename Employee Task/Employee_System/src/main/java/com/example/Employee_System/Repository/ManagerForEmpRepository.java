package com.example.Employee_System.Repository;

import com.example.Employee_System.Entity.EmployeeData;
import com.example.Employee_System.Entity.ManagerForEmployee;
import com.example.Employee_System.Entity.RoleMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerForEmpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addManagerForEmployee(ManagerForEmployee managerForEmployee) {
        // Fetch the next value for the ID sequence
        String getIdSql = "SELECT manager_for_employee_seq.NEXTVAL FROM dual";
        Long id = jdbcTemplate.queryForObject(getIdSql, Long.class);

        // Insert the ManagerForEmployee record
        String insertSql = "INSERT INTO manager_for_employee (id, role_id, emp_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(insertSql,
                id,
                managerForEmployee.getManager().getId(),
                managerForEmployee.getEmp().getEmp_Id());
    }
}
