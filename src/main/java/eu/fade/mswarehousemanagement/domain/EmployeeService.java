package eu.fade.mswarehousemanagement.domain;

import java.util.List;

import eu.fade.mswarehousemanagement.infrastructure.EmployeeEmRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeEmRepository repository;

    public EmployeeService(EmployeeEmRepository repository) {
        this.repository = repository;
    }


    public void printServiceName() {
        System.out.println("EmployeeService");
    }

    public Employee findById(int id) {
        return this.repository.getById(id);
    }

    public List<Employee> findByName(String name) {
        return this.repository.findByName(name);
    }

    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }
}
