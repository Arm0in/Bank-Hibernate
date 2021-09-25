package ir.maktab.bankapp.repository;

import ir.maktab.bankapp.base.repository.BaseRepository;
import ir.maktab.bankapp.domain.Card;

public interface CardRepository extends BaseRepository<Card, Long> {
    Card getCardByNumber(String cardNmbr);
}
