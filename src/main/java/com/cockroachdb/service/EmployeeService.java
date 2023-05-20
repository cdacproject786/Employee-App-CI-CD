package com.cockroachdb.service;

import com.cockroachdb.dto.EmployeeRequest;
import com.cockroachdb.dto.EmployeeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface EmployeeService {

    public List<EmployeeResponse> getAllEmployee();
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest);
    public EmployeeResponse updateEmployee(EmployeeRequest request);
    public void deleteEmployee(long id);
    public EmployeeResponse getEmployeeById(Long id);
}
