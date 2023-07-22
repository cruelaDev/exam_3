package org.example.atm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.BaseEntity;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ATM extends BaseEntity<UUID> {
    private UUID id;
    private String name;
    private int percentTransaction;
}
