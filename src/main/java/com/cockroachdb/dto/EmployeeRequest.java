package com.cockroachdb.dto;

import com.cockroachdb.encrypt.MaskDada;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRequest {

    private long empId;
    @NotBlank(message = "First Name cannot be null")
    private String fname;

    @NotBlank(message = "Last Name cannot be null")
    private String lname;

    @NotBlank(message = "Department cannot be null")
    private String department;

    @NotBlank(message = "email is mandatory. cannot be blank")
    @Email
    @MaskDada
    private String email;

    @NotBlank(message = "phone no is mandatory. cannot be blank")
    @MaskDada
    private String phone;

    @Min(message = "Salary minimum value is 40000", value = 40000)
    @Max(message = "Salary max is 1000000",value = 1000000)
    private int salary;
}
