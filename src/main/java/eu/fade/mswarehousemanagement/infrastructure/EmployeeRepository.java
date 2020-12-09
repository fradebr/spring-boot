package eu.fade.mswarehousemanagement.infrastructure;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import eu.fade.mswarehousemanagement.domain.Employee;
import eu.fade.mswarehousemanagement.domain.EmployeePerFunction;
import eu.fade.mswarehousemanagement.domain.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getEmployeeByLastName(String lastName);

    List<Employee> getEmployeeByFirstNameIgnoreCase(String firstName);

    List<Employee> getEmployeeByLastNameLike(String namePart);

    List<Employee> findEmployeeByDateInServiceAfter(LocalDate date);

    Optional<Employee> getEmployeeByEmployeeNumber(String employeeNumber);

    List<Employee> findEmployeeByFunction(Function function);

    @Query(value = "select avg(e.wage) from Employee e")
    Double getAverageWage();

    @Query(value = "select new eu.fade.mswarehousemanagement.domain.EmployeePerFunction(e.function, count(e)) from Employee e group by e.function")
    List<EmployeePerFunction> getEmployeePerFunction();

    Long countEmployeesByFunction(Function function);
}
