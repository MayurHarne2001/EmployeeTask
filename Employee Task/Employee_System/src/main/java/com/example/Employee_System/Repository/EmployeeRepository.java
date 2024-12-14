package com.example.Employee_System.Repository;


import com.example.Employee_System.Entity.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addEmployee(EmployeeData employee) {
        String sql = "INSERT INTO employee_data (EMP_ID, NAME, PHONE_NO) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getEmp_Id(), employee.getName(), employee.getPhoneNo());
    }

    public EmployeeData getEmployee(Long emp_Id) {
        String sql = "SELECT EMP_ID, NAME, PHONE_NO FROM employee_data WHERE EMP_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{emp_Id}, new EmployeeRowMapper());
    }

    private static class EmployeeRowMapper implements RowMapper<EmployeeData> {
        @Override
        public EmployeeData mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmployeeData employee = new EmployeeData();
            employee.setEmp_Id(rs.getLong("EMP_ID"));
            employee.setName(rs.getString("NAME"));
            employee.setPhoneNo(rs.getString("PHONE_NO"));
            return employee;
        }
    }
}
