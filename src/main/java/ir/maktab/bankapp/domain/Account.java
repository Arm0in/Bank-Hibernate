package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import ir.maktab.bankapp.domain.enumaration.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Double balance;
    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Branch branch;

    @OneToOne
    private Card card;

}
