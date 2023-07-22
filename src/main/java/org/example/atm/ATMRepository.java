package org.example.atm;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.BaseRepository;

import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ATMRepository extends BaseRepository<UUID, ATM> {
    private static final ATMRepository repository = new ATMRepository();

    public ATM findByName(String name) {
        ArrayList<ATM> atms = new ArrayList<>(entities.values());
        for (ATM atm : atms) {
            if (atm.getName().equals(name)) {
                return atm;
            }
        }
        return null;
    }

    public static ATMRepository getInstance() {
        return repository;
    }
}
