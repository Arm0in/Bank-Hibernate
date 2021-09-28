package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import ir.maktab.bankapp.domain.enumaration.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = Employee.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity<Long> {

    public static final String TABLE_NAME = "employee_table";

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;


}
