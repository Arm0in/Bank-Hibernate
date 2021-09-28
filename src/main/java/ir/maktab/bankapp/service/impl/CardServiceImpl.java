package ir.maktab.bankapp.service.impl;

import ir.maktab.bankapp.base.service.impl.BaseServiceImpl;
import ir.maktab.bankapp.domain.Card;
import ir.maktab.bankapp.repository.CardRepository;
import ir.maktab.bankapp.service.CardService;

import java.time.LocalDate;

public class CardServiceImpl extends BaseServiceImpl<Card, Long, CardRepository> implements CardService {

    public CardServiceImpl(CardRepository repository) {
        super(repository);
    }

    @Override
    public Card getCardByNumber(String cardNmbr) {
        return repository.getCardByNumber(cardNmbr);
    }

    @Override
    public void authenticatePin(String cardNumbr, String pin, LocalDate expireDate, String cvv) {
        Card card = getCardByNumber(cardNumbr);
        if (card != null) {
            if (!pin.equals(card.getPin()) && !expireDate.equals(card.getExpireDate()) && !cvv.equals(card.getCvv())) {
                card.setCountFailedAttempts(card.getCountFailedAttempts() + 1);
                if (card.getCountFailedAttempts() >= 3)
                    card.setIsActive(false);
                throw new RuntimeException("Account credentials Wrong!!!" + (3 - card.getCountFailedAttempts()) + " more attempts");
            }
        } else {
            throw new RuntimeException("not found!!!");
        }
    }
}
