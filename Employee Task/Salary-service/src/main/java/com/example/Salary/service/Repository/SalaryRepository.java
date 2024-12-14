package com.example.Salary.service.Repository;

import com.example.Salary.service.Entity.Salary_Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalaryRepository {

    @Autowired
   private JdbcTemplate jdbcTemplate;

    public int addSalary(Salary_Data salary){
        String sql = "INSERT INTO SALARY_DATA( EMP_ID, SALARY) VALUES(?, ?)";
        return jdbcTemplate.update(sql, salary.getEmp_Id(), salary.getSalary());

    }
    public Double getSalaryById(Long emp_Id){
        String sql="Select SALARY from Salary_Data Where EMP_ID=?";
        return jdbcTemplate.queryForObject(sql,Double.class,emp_Id);
    }
    public  int updateSalary(Long emp_Id,Double salary){
        String sql="UPDATE Salary_Data SET salary = ? WHERE emp_id = ?";
        return jdbcTemplate.update(sql,salary,emp_Id);
    }
    public Double getCurrentSalary(Long emp_Id){
        String sql="Select SALARY from Salary_Data Where EMP_ID=?";
        return jdbcTemplate.queryForObject(sql, Double.class,emp_Id);
    }
}
