package ru.venidiktov.springiscoming.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.venidiktov.springiscoming.constant.ProfileConstants;
import ru.venidiktov.springiscoming.properties.IronBankProperties;

/**
 * При наступлении зимы Железный Банк дает кредиты только тем кто возвращает долги
 */
@Service
@Profile(ProfileConstants.ЗИМА_ТУТА)
@RequiredArgsConstructor
public class WinterProphetService implements ProphetService {
    private final IronBankProperties ironBankProperties;

    @Override
    public boolean approveCredit(String name) {
        return ironBankProperties.repayDebts().stream().anyMatch(house -> house.equalsIgnoreCase(name));
    }
}
