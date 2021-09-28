package ir.maktab.bankapp.service.impl;

import ir.maktab.bankapp.base.service.impl.BaseServiceImpl;
import ir.maktab.bankapp.domain.Employee;
import ir.maktab.bankapp.repository.EmployeeRepository;
import ir.maktab.bankapp.service.EmployeeService;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long, EmployeeRepository> implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return repository.getEmployeeByUsername(username);
    }
}
