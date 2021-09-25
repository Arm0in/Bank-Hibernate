package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity<Long> {
    @Column(name = "card_number", unique = true, length = 16)
    private String cardNumber;
    private String cvv;
    private String pin;
    private Boolean isActive;
    @OneToOne
    private Account account;
    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Transient
    private int countFailedAttempts = 0;

}
