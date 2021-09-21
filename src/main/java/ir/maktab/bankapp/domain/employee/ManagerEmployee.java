package ir.maktab.bankapp.domain.employee;

import ir.maktab.bankapp.domain.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerEmployee extends Employee {
    @OneToOne
    private Branch branch;
}
