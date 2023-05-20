package com.cockroachdb;

import com.cockroachdb.dto.EmployeeRequest;
import com.cockroachdb.entity.Employee;
import com.cockroachdb.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CockroachdbCrudApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ModelMapper modelMapper;

	public static void main(String[] args) {
		SpringApplication.run(CockroachdbCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> employeeList = new ArrayList<>(10);
		employeeList.add(new Employee("Arbaaz","Sayed","Java-Web","arebaaz.sayed@gmail.com","8390816370",67000));
		employeeList.add(new Employee("Abhishek","Bagel","Java-Web","abhishek@gmail.com","9822140878",76000));
		employeeList.add(new Employee("Vimlesh","Paswan","Dev-Ops","vimlesh@gmail.com","7057346416",56765));
		employeeList.add(new Employee("Acchutam","Kulthe","Front-End","acchutam@gmail.com","839064576",56000));
		employeeList.add(new Employee("Jinisha","Gehlot","Java-Web","jinisha@gmail.com","4590876567",87600));


		for(Employee employee : employeeList)
			this.employeeService.saveEmployee(this.modelMapper.map(employee, EmployeeRequest.class));
	}
}
