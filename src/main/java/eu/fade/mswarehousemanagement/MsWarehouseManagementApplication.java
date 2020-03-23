package eu.fade.mswarehousemanagement;

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
        };
    }
}
