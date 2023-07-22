package org.example.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.BaseEntity;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseEntity<UUID> {
    private UUID id;
    private String cardNumber;
    private float balance;
    private String password;
    private UUID userId;
    private boolean active;
}
