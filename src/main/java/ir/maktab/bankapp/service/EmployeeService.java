package ir.maktab.bankapp.service;

import ir.maktab.bankapp.base.service.BaseService;
import ir.maktab.bankapp.domain.Employee;

public interface EmployeeService extends BaseService<Employee, Long> {
    Employee getEmployeeByUsername(String username);
}
