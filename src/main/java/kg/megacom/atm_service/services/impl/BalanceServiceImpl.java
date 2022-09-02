package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.BalanceRepo;
import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.services.BalanceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepo balanceRepo;

    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @Override
    public Optional<Balance> getBalanceById(Long balanceId) {
        return balanceRepo.findById(balanceId);
    }
}
