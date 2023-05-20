package com.cockroachdb.controller;

import com.cockroachdb.dto.EmployeeRequest;
import com.cockroachdb.dto.EmployeeResponse;
import com.cockroachdb.dto.ExceptionResponse;
import com.cockroachdb.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Employee-App",description = "Simple Employee Management System")
@RestController
@RequestMapping("/api")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

   /* @Operation(
            summary = "Get All Employee",
            description = "Retrieve all the employee present in the database",
            tags = {"Employees","get"})*/
    @ApiResponses({
    @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = EmployeeResponse.class),mediaType = "application/json")}),
    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
    @ApiResponse(responseCode = "500",content = {@Content(schema = @Schema())})
    })
    @GetMapping("/employee")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> getAllStudents()
    {
        return new ResponseEntity<>(this.employeeService.getAllEmployee(), HttpStatus.OK);
    }




 /*   @Operation(
            summary = "Save an Employee",
            description = "Save a new Employee to the database",
            tags = {"Employee","post"})*/
    @ApiResponses({
            @ApiResponse(responseCode = "201",content = {@Content(schema = @Schema(implementation = EmployeeResponse.class),mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",content = {@Content(schema = @Schema())})
    })
    @PostMapping("/employee")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeRequest request)
    {
        return new ResponseEntity<>(this.employeeService.saveEmployee(request),HttpStatus.OK);
    }


  /*  @Operation(
            summary = "Get employee by id",
            description = "Get an employee from database using employee by id",
            tags = {"Employee","get"})*/
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = EmployeeResponse.class),mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",content = @Content(schema = @Schema(implementation = ExceptionResponse.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",content = {@Content(schema = @Schema())})
    })
    @GetMapping("/employee/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id")Long id)
    {
        return new ResponseEntity<>(this.employeeService.getEmployeeById(id),HttpStatus.CREATED);
    }


   /* @Operation(
            summary = "Update an employee",
            description = "Update data of an existing employee with a PUT request",
            tags = {"Employee","put"})*/
    @ApiResponses({
            @ApiResponse(responseCode = "200",content = {@Content(schema = @Schema(implementation = EmployeeResponse.class),mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",content = @Content(schema = @Schema(implementation = ExceptionResponse.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",content = {@Content(schema = @Schema())})
    })
    @PutMapping("/employee")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequest employeeRequest)
    {
        return new ResponseEntity<>(this.employeeService.updateEmployee(employeeRequest),HttpStatus.OK);
    }

 /*   @Operation(
            summary = "Delete an employee",
            description = "Delete data of an existing employee with a DELETE request",
            tags = {"Employee","delete"})*/
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "400",content = @Content(schema = @Schema(implementation = ExceptionResponse.class),mediaType = "application/json")),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500",content = {@Content(schema = @Schema())})
    })
    @DeleteMapping("/employee/{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id)
    {
        return new ResponseEntity<>(null,HttpStatus.OK);

    }

}
