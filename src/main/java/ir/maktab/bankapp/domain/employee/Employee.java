package ir.maktab.bankapp.domain.employee;

import ir.maktab.bankapp.domain.User;
import ir.maktab.bankapp.domain.enumaration.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = Employee.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {

    public static final String TABLE_NAME = "employee_table";

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;


}
