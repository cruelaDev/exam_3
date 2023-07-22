package org.example.card;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardRepository extends BaseRepository<UUID, Card> {
    private static final CardRepository cardRepository = new CardRepository();

    public Card findByCardNumber(String cardNumber) {
        ArrayList<Card> cards = new ArrayList<>(entities.values());
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    public static CardRepository getInstance() {
        return cardRepository;
    }
}
