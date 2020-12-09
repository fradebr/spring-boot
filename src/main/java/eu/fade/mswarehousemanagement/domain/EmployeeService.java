package eu.fade.mswarehousemanagement.domain;

import java.time.LocalDate;
import java.util.List;

import eu.fade.mswarehousemanagement.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }


    public void printServiceName() {
        System.out.println("EmployeeService");
    }

    public Employee findById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unknown employee"));
    }

    public List<Employee> findByName(String name) {
        return this.repository.getEmployeeByLastName(name);
    }

    public List<Employee> findByFirstName(String firstName) {
        return this.repository.getEmployeeByFirstNameIgnoreCase(firstName);
    }

    public List<Employee> findByLastNamePart(String lastNamePart) {
        return this.repository.getEmployeeByLastNameLike(lastNamePart);
    }

    public List<Employee> findInDateSince(LocalDate date) {
        return this.repository.findEmployeeByDateInServiceAfter(date);
    }

    public Employee findByEmployeeNumber(String employeeNumber) {
        return this.repository.getEmployeeByEmployeeNumber(employeeNumber).orElseThrow(() -> new IllegalArgumentException("Unknown employee"));
    }

    public List<Employee> findByFunction(Function function) {
        return this.repository.findEmployeeByFunction(function);
    }

    public Double getAverageWage() {
        return this.repository.getAverageWage();
    }

    public List<EmployeePerFunction> getEmployeePerFunction() {
        return this.repository.getEmployeePerFunction();
    }

    public Long countEmployeesForFunction(Function function) {
        return  this.repository.countEmployeesByFunction(function);
    }

    public Employee update(Employee employee) {
        return this.repository.save(employee);
    }
}
