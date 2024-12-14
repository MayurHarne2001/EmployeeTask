package com.example.Employee_System.Service;

import com.example.Employee_System.Config.WebClientConfig;
import com.example.Employee_System.Dto.EmployeeWithSalary;
import com.example.Employee_System.Entity.EmployeeData;
import com.example.Employee_System.Repository.EmployeeRepository;
import com.example.Employee_System.Repository.RoleMappingRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private StockClient stockClient;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleMappingRepository roleMappingRepository;


    public String addEmployee(EmployeeData employee) {
        int rows = employeeRepository.addEmployee(employee);
        if (rows > 0) {
            if(employee.getEmp_Id()==2000L){
                roleMappingRepository.insertRoleMapping(employee.getEmp_Id(), 2000L);
            }
            else if(employee.getEmp_Id()==3000L){
                roleMappingRepository.insertRoleMapping(employee.getEmp_Id(), 3000L);
            }
            else if(employee.getEmp_Id()==4000L){
                roleMappingRepository.insertRoleMapping(employee.getEmp_Id(), 4000L);
            }
            else {
                roleMappingRepository.insertRoleMapping(employee.getEmp_Id(), 1000L);
            }
            return "Employee added successfully!";
        } else {
            return "Failed to add employee.";
        }
    }
    public EmployeeData getEmployee(Long emp_Id){
        return employeeRepository.getEmployee(emp_Id);
    }
    public EmployeeWithSalary getEmployeeWithSalary(Long empId) {
        // Fetch Employee Details
        EmployeeData employee = employeeRepository.getEmployee(empId);

        // Fetch Salary Details from Salary Service
        Double salary = webClient.get()
                .uri("http://localhost:2015/salary/getSalaryById?emp_Id=" + empId)
                .retrieve()
                .bodyToMono(Double.class)
                .block();

        // Combine Employee and Salary Details
        EmployeeWithSalary employeeWithSalary = new EmployeeWithSalary();
        employeeWithSalary.setEmpId(employee.getEmp_Id());
        employeeWithSalary.setName(employee.getName());
        employeeWithSalary.setPhoneNo(employee.getPhoneNo());
        employeeWithSalary.setSalary(salary);

        return employeeWithSalary;
    }
//-------------------------Using ExcellSheet-------------------------------------

    public void processEmployeeExcel(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        // Skip header row
        if (rowIterator.hasNext()) rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Long empId = (long) row.getCell(0).getNumericCellValue();
            String name = row.getCell(1).getStringCellValue();
            String phoneNo = row.getCell(2).getStringCellValue();


            employeeRepository.addEmployee(new EmployeeData(empId, name, phoneNo));
        }

        workbook.close();
    }


}
