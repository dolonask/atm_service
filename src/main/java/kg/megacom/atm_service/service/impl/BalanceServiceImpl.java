package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Balance;
import kg.megacom.atm_service.repository.BalanceRepo;
import kg.megacom.atm_service.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepo balanceRepo;

    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @Override
    public Balance createBalance() {
        Balance balance = new Balance();
        balance.setAmount(0);
        balance.setBlockedAmount(0);
        balanceRepo.save(balance);
        return balance;
    }
}
