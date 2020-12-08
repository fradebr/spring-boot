package eu.fade.mswarehousemanagement;

import java.util.List;

import eu.fade.mswarehousemanagement.domain.Employee;
import eu.fade.mswarehousemanagement.domain.EmployeeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsWarehouseManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsWarehouseManagementApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(EmployeeService employeeService) {
        return args -> {
            employeeService.printServiceName();
            Employee employee1 = employeeService.findById(1052);
            System.out.println(employee1);

            List<Employee> employees = employeeService.findByName("ew");
            employees.forEach(System.out::println);

            Employee employeeToUpdate = employeeService.findById(1052);
            System.out.println(employeeToUpdate);
            employeeToUpdate.setWage(999999.00);
            employeeService.update(employeeToUpdate);

            Employee employeeUpdated = employeeService.findById(1052);
            System.out.println(employeeUpdated);
        };
    }
}
