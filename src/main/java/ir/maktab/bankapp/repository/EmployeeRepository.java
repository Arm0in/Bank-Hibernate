package ir.maktab.bankapp.repository;

import ir.maktab.bankapp.base.repository.BaseRepository;
import ir.maktab.bankapp.domain.Employee;

public interface EmployeeRepository extends BaseRepository<Employee, Long> {
    Employee getEmployeeByUsername(String username);
}
