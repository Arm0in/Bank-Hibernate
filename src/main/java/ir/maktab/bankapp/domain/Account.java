package ir.maktab.bankapp.domain;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import ir.maktab.bankapp.base.domain.BaseEntity;
import ir.maktab.bankapp.domain.enumaration.AccountType;
import ir.maktab.bankapp.util.ApplicationContext;
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
    private Double balance = 0d;
    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Branch branch;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    public void setCard() {
        Faker faker = new Faker();
        String cardNmbr = faker.finance().creditCard(CreditCardType.VISA).replaceAll("-", "");
        Card card = new Card(cardNmbr, Long.toString(faker.number().randomNumber(4, true)),
                Long.toString(faker.number().randomNumber(4, true)),
                true, this, LocalDate.now().plusYears(5), 0);
        while (true) {
            try {
                ApplicationContext.getCardService().getCardByNumber(cardNmbr);
                card.setCardNumber(faker.finance().creditCard(CreditCardType.VISA).replaceAll("-", ""));
            } catch (NoResultException e) {
                this.card = card;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                getId() + ". " +
                "accountType=" + accountType +
                ", balance=" + balance +
                ", createdDate=" + createdDate +
                ", branch=" + branch.getBranchName() +
                ", card=" + card.getCardNumber().substring(0, 3) + " **** **** " + card.getCardNumber().substring(12, 15) +
                '}';
    }
}
