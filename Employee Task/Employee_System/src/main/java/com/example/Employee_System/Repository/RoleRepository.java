package com.example.Employee_System.Repository;




import com.example.Employee_System.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class RoleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addRole(Role role) {
        String sql = "INSERT INTO role (role_Id,designation) VALUES ( ?, ?)";
        return jdbcTemplate.update(sql, role.getRole_Id(),role.getDesignation());
    }


}
