package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.Balance;

public interface BalanceService {
    Balance createBalance();

    Balance setNewBalance(double amount, Long balanceId);
}
