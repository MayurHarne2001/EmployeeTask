package com.example.Employee_System.Controller;


import com.example.Employee_System.Dto.EmployeeWithSalary;
import com.example.Employee_System.Entity.EmployeeData;
import com.example.Employee_System.Entity.Role;
import com.example.Employee_System.Entity.Stock;
import com.example.Employee_System.Service.EmployeeService;
import com.example.Employee_System.Service.RoleService;
import com.example.Employee_System.Service.StockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {

    @Autowired
    private StockClient stockClient;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeData employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/add/role")
    public String addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }
    @GetMapping("/getEmployee")
    public EmployeeData getEmployee(@RequestParam Long emp_Id){
             return employeeService.getEmployee(emp_Id);
    }

    @PostMapping("/add/stock")
    private String addStock(@RequestBody Stock stock){
        return stockClient.addStock(stock);
    }

    @GetMapping
    private ResponseEntity<List<Stock>> getAllStock(){
        List<Stock> stocks= stockClient.getAllStock();
        return  ResponseEntity.ok(stocks);
    }
    @GetMapping("/by-category")
    public ResponseEntity<List<Stock>> getStockByCategory(@RequestParam("category") String category) {
        List<Stock> stock = stockClient.getStockByCategory(category);
        return ResponseEntity.ok(stock);
    }
    @GetMapping("/getEmployeeWithSalary")
    public EmployeeWithSalary getEmployeeWithSalary(@RequestParam Long empId) {
        return employeeService.getEmployeeWithSalary(empId);
    }
}
