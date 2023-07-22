package org.example.atm;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.Service;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class ATMService implements Service<ATM, UUID> {
    private static ATMRepository atmRepository = ATMRepository.getInstance();
    private static final ATMService service = new ATMService();

    @Override
    public ATM findById(UUID uuid) {
        return atmRepository.findById(uuid);
    }

    @Override
    public List<ATM> getAll() {
        return atmRepository.getAll();
    }

    @Override
    public void remove(UUID uuid) {
        atmRepository.delete(uuid);
    }

    @Override
    public ATM add(ATM atm) {
        List<ATM> atms = getAll();
        for (ATM atm1 : atms) {
            if (atm1.getName().equals(atm.getName())) {
                return null;
            }
        }
        return atmRepository.add(atm);
    }

    public static ATMService getInstance() {
        return service;
    }
}
