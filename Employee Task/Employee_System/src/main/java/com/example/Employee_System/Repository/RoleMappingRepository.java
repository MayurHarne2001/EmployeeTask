package com.example.Employee_System.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleMappingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertRoleMapping(Long emp_Id, Long role_Id) {
        // Get the next value of the sequence
        String getIdSql = "SELECT role_mapping_seq.NEXTVAL FROM dual";
        Long id = jdbcTemplate.queryForObject(getIdSql, Long.class);

        // Insert the RoleMapping with the generated ID
        String sql = "INSERT INTO role_mapping (id, emp_id, role_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, emp_Id, role_Id);
    }

    public int updateRoleMapping(Long emp_Id, Long role_Id) {
        String sql = "UPDATE role_mapping SET ROLE_ID = ? WHERE EMP_ID = ?";
        return jdbcTemplate.update(sql, role_Id, emp_Id);
    }

}
