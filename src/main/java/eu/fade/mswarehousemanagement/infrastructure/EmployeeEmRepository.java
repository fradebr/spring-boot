package eu.fade.mswarehousemanagement.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

import eu.fade.mswarehousemanagement.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeEmRepository {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee getById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;

    }

    public List<Employee> findByName(String name) {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee  e where e.lastName like ?1", Employee.class);
        query.setParameter(1, "%" + name + "%");

        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Transactional
    public Employee update(Employee employee) {

        Employee e = entityManager.merge(employee);
        entityManager.persist(e);
        return employee;
    }
}
