package ru.venidiktov.springiscoming.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class NameBasedProphetService implements ProphetService {

    /**
     * Определяет комы можно выдать кредит, а кому нет
     * Если дом 'Stark' то точно нет, в остальных случаях рандомно
     *
     * @param name - имя дома
     * @return - true значит можно выдать, false значит нельзя выдать кредит
     */
    @Override
    public boolean willSurvive(String name) {
        return !name.equalsIgnoreCase("stark") && ThreadLocalRandom.current().nextBoolean();
    }
}
