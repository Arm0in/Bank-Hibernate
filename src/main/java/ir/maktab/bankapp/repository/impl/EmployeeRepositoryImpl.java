package ir.maktab.bankapp.repository.impl;

import ir.maktab.bankapp.base.repository.BaseRepositoryImpl;
import ir.maktab.bankapp.domain.Employee;
import ir.maktab.bankapp.repository.EmployeeRepository;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee, Long> implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return entityManager.createQuery(
                "from Employee e where e.username = :username", Employee.class
        ).setParameter("username", username).getSingleResult();
    }
}
