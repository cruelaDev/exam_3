package org.example.card;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.Service;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardService implements Service<Card, UUID> {
    private static final CardService service = new CardService();
    private final CardRepository cardRepository = CardRepository.getInstance();

    @Override
    public Card findById(UUID uuid) {
        return cardRepository.findById(uuid);
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.getAll();
    }

    @Override
    public void remove(UUID uuid) {
        cardRepository.delete(uuid);
    }

    @Override
    public Card add(Card card) {
        List<Card> cards = getAll();
        for (Card existingCard : cards) {
            if (existingCard.getCardNumber().equals(card.getCardNumber())) {
                return null;
            }
        }
        return cardRepository.add(card);
    }

    public static CardService getInstance() {
        return service;
    }
}
