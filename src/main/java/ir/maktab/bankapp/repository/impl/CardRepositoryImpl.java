package ir.maktab.bankapp.repository.impl;

import ir.maktab.bankapp.base.repository.BaseRepositoryImpl;
import ir.maktab.bankapp.domain.Card;
import ir.maktab.bankapp.repository.CardRepository;

import javax.persistence.EntityManager;

public class CardRepositoryImpl extends BaseRepositoryImpl<Card, Long> implements CardRepository {
    public CardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Card> getEntityClass() {
        return Card.class;
    }

    @Override
    public Card getCardByNumber(String cardNumber) {
        return entityManager.createQuery(
                "from Card c where c.cardNumber = :cardNumber", Card.class
        ).setParameter("cardNumber", cardNumber).getSingleResult();
    }
}
