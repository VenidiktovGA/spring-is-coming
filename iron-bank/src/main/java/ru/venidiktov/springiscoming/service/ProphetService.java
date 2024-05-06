package ru.venidiktov.springiscoming.service;

/**
 * Сервис предсказаний, определяем можно ли выдать дому кредит
 */
public interface ProphetService {

    /**
     * Определяет комы можно выдать кредит, а кому нет
     *
     * @param name - имя дома
     * @return - true значит можно выдать, false значит нельзя выдать кредит
     */
    boolean approveCredit(String name);
}
