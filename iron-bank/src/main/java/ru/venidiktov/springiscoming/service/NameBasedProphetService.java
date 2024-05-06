package ru.venidiktov.springiscoming.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.venidiktov.springiscoming.constant.ProfileConstants;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Пока не зима и стена целая Железный банк однозначно отказывает только дому Stark, остальным 50/50
 */
@Service
@Profile(ProfileConstants.ЗИМА_БЛИЗКО)
public class NameBasedProphetService implements ProphetService {

    /**
     * Определяет комы можно выдать кредит, а кому нет
     * Если дом 'Stark' то точно нет, в остальных случаях рандомно
     *
     * @param name - имя дома
     * @return - true значит можно выдать, false значит нельзя выдать кредит
     */
    @Override
    public boolean approveCredit(String name) {
        return !name.equalsIgnoreCase("stark") && ThreadLocalRandom.current().nextBoolean();
    }
}
