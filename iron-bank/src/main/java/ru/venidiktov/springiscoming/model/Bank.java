package ru.venidiktov.springiscoming.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Сущность банка, в реальном приложении это была бы Entity
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    private long totalAmount;

    public void credit(long amount) {
        totalAmount -= amount;
    }
}
