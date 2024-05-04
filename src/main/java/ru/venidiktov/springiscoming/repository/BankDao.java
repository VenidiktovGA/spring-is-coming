package ru.venidiktov.springiscoming.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.venidiktov.springiscoming.model.Bank;

/**
 * В боевом приложении это был бы Repository
 */
@Component
@Getter
public class BankDao {

    private final Bank ironBank = new Bank(1_000_000_000);

}
