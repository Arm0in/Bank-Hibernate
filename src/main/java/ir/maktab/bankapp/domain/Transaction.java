package ir.maktab.bankapp.domain;

import ir.maktab.bankapp.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = Transaction.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class Transaction extends BaseEntity<Long> {

    public static final String TABLE_NAME = "transaction_table";
    public static final Double FEE = 600d;

    private Double amount;
    private LocalDateTime time;

    @OneToOne
    private Card sender;
    @OneToOne
    private Card receiver;

    public Transaction(Double amount, Card sender, Card receiver) {
        this.amount = amount;
        this.time = LocalDateTime.now();
        this.sender = sender;
        this.receiver = receiver;
    }
}
