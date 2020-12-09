package eu.fade.mswarehousemanagement;

import java.time.LocalDate;
import java.util.List;

import eu.fade.mswarehousemanagement.domain.Employee;
import eu.fade.mswarehousemanagement.domain.EmployeePerFunction;
import eu.fade.mswarehousemanagement.domain.EmployeeService;
import eu.fade.mswarehousemanagement.domain.Function;
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
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");
            List<Employee> employees = employeeService.findByName("ew");
            employees.forEach(System.out::println);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");
            Employee employeeToUpdate = employeeService.findById(1052);
            System.out.println(employeeToUpdate);
            employeeToUpdate.setWage(employeeToUpdate.getWage() * 1.01);
            employeeService.update(employeeToUpdate);
            Employee employeeUpdated = employeeService.findById(1052);
            System.out.println(employeeUpdated);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            employees = employeeService.findByFirstName("Amy");
            employees.forEach(System.out::println);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            employees = employeeService.findByLastNamePart("%ew%");
            employees.forEach(System.out::println);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            employees = employeeService.findInDateSince(LocalDate.of(2021,1,1));
            employees.forEach(System.out::println);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            try {
                employee1 = employeeService.findByEmployeeNumber("1234567");
                System.out.println(employee1);
            } catch (IllegalArgumentException ex) {
                System.out.println("Employee with number 1234567 was not found");
            }
            System.out.println("      ");
            employee1 = employeeService.findByEmployeeNumber("16100123 9928");
            System.out.println(employee1);

            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            employees = employeeService.findByFunction(Function.LEAD);
            employees.forEach(System.out::println);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            Double averageWage = employeeService.getAverageWage();
            System.out.println("Average was is " + averageWage);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            List<EmployeePerFunction> employeePerFunctions = employeeService.getEmployeePerFunction();
            employeePerFunctions.forEach(System.out::println);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");

            Long numberOfEmployees = employeeService.countEmployeesForFunction(Function.EMPLOYEE);
            System.out.println("There are " + numberOfEmployees + " employees in the function of " + Function.EMPLOYEE);
            System.out.println("      ");
            System.out.println("**********************************************************************************");
            System.out.println("      ");
        };
    }
}
