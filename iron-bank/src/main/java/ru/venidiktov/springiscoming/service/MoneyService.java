package ru.venidiktov.springiscoming.service;

public interface MoneyService {
    void deposit(long amount);

    long transfer(String name, long amount);
}
