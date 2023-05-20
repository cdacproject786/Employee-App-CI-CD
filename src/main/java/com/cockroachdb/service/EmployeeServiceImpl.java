package com.cockroachdb.service;

import com.cockroachdb.dto.EmployeeRequest;
import com.cockroachdb.dto.EmployeeResponse;
import com.cockroachdb.entity.Employee;
import com.cockroachdb.exception.ResourceNotFoundException;
import com.cockroachdb.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    //code to get list of employees
    public List<EmployeeResponse> getAllEmployee()
    {
        List<Employee> listFromDb = this.employeeRepository.findAll();
        ArrayList<EmployeeResponse> responseList = new ArrayList<>(listFromDb.size());

        for(Employee item:listFromDb)
            responseList.add(this.modelMapper.map(item,EmployeeResponse.class));

        return responseList;
    }

    //code to save a employee to the db
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest)
    {
        Employee employee = this.modelMapper.map(employeeRequest,Employee.class);
        employee = this.employeeRepository.save(employee);
        return this.modelMapper.map(employee,EmployeeResponse.class);
    }

    //update employee code
    public EmployeeResponse updateEmployee(EmployeeRequest request)
    {
        Employee empFromDb = this.employeeRepository.findById(request.getEmpId()).get();
        if(empFromDb == null)
            throw new ResourceNotFoundException("There is no resource available with given id");
        else {
         empFromDb.setFname(request.getFname());
         empFromDb.setLname(request.getLname());
         empFromDb.setDepartment(request.getDepartment());
         empFromDb.setSalary(request.getSalary());
         empFromDb.setPhone(request.getPhone());
         Employee updatedEmployee = this.employeeRepository.save(empFromDb);
         return this.modelMapper.map(updatedEmployee,EmployeeResponse.class);
        }
    }

    //delete employee code
    public void deleteEmployee(long id)
    {
        Employee employee = this.employeeRepository.findById(id).get();
        if(employee == null)
            throw new ResourceNotFoundException("Employee with id: "+id+" does not exist");
        else
            this.employeeRepository.deleteById(id);
    }

    //find employee by id code
    public EmployeeResponse getEmployeeById(Long id)
    {
        Employee foundEmployee = this.employeeRepository.findById(id).get();
        if(foundEmployee == null)
            throw new ResourceNotFoundException("Employee with id "+id+" does not exist");
        return this.modelMapper.map(foundEmployee,EmployeeResponse.class);
    }

}
