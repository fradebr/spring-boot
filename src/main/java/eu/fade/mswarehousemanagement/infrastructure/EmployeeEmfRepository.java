package eu.fade.mswarehousemanagement.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import java.util.List;

import eu.fade.mswarehousemanagement.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeEmfRepository {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Employee getById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, id);
        return employee;

    }

    public List<Employee> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employee> query = em.createQuery("select e from Employee  e where e.lastName like ?1", Employee.class);
        query.setParameter(1, "%" + name + "%");

        List<Employee> employees = query.getResultList();
        return employees;
    }


    public Employee update(Employee employee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Employee e = em.merge(employee);
        em.persist(e);
        tx.commit();
        return employee;
    }

}
