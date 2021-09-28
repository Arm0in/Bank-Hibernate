package ir.maktab.bankapp.service.impl;

import ir.maktab.bankapp.base.service.impl.BaseServiceImpl;
import ir.maktab.bankapp.domain.Card;
import ir.maktab.bankapp.domain.Transaction;
import ir.maktab.bankapp.repository.TransactionRepository;
import ir.maktab.bankapp.service.TransactionService;
import ir.maktab.bankapp.util.ApplicationContext;

public class TransactionServiceImpl extends BaseServiceImpl<Transaction, Long, TransactionRepository> implements TransactionService {

    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }

    @Override
    public Boolean validateTransaction(String sender, String receiver, Double amount) {
        Card senderCard = ApplicationContext.getCardService().getCardByNumber(sender);
        Card receiverCard = ApplicationContext.getCardService().getCardByNumber(receiver);
        if (senderCard != null && receiverCard != null) {
            if (senderCard.getIsActive()) {
                if (senderCard.getAccount().getBalance() >= amount + Transaction.FEE) {
                    return true;
                } else
                    throw new RuntimeException("Not enough balance!");
            } else {
                throw new RuntimeException("Your card is not active!!!");
            }
        } else {
            throw new RuntimeException("sender or receiver card number is wrong!!!");
        }
    }
}
