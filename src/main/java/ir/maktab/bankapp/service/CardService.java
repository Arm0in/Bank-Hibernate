package ir.maktab.bankapp.service;

import ir.maktab.bankapp.base.service.BaseService;
import ir.maktab.bankapp.domain.Card;

import java.time.LocalDate;

public interface CardService extends BaseService<Card, Long> {
    Card getCardByNumber(String cardNmbr);
    void authenticatePin(String cardNmbr, String pin, LocalDate expireDate, String cvv);
}
