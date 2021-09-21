package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import ir.maktab.bankapp.domain.employee.ManagerEmployee;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Branch extends BaseEntity<Long> {

    private String branchName;

    @OneToOne
    private ManagerEmployee manager;

}
