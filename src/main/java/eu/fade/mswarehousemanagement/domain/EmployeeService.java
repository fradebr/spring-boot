package eu.fade.mswarehousemanagement.domain;

import java.util.List;

import eu.fade.mswarehousemanagement.infrastructure.EmployeeEmfRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeEmfRepository repository;

    public EmployeeService(EmployeeEmfRepository repository) {
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
