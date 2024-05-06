package ru.venidiktov.springiscoming.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.venidiktov.springiscoming.model.Bank;
import ru.venidiktov.springiscoming.repository.BankDao;

@Service
@RequiredArgsConstructor
public class MoneyServiceImpl implements MoneyService {
    private final BankDao bankDao;
    private final ProphetService prophetService;

    /**
     * Положить деньги в банк
     *
     * @param depositedAmount - сумма золота, которая кладется в банк
     */
    @Override
    public void deposit(long depositedAmount) {
        Bank ironBank = bankDao.getIronBank();
        var newAmount = depositedAmount + ironBank.getTotalAmount();
        ironBank.setTotalAmount(newAmount);
    }

    @Override
    public long transfer(String name, long amount) {
        Bank ironBank = bankDao.getIronBank();
        if (ironBank.getTotalAmount() - amount > 0 && prophetService.approveCredit(name)) {
            ironBank.credit(amount);
            return ironBank.getTotalAmount();
        }
        return -1;
    }
}
