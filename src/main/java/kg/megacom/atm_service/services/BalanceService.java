package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.entities.Balance;

import java.util.Optional;

public interface BalanceService {
    Optional<Balance> getBalanceById(Long balanceId);
}