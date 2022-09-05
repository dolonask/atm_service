package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.dto.BalanceDto;
import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.models.response.BalanceResponse;
import org.springframework.data.repository.query.Param;

public interface BalanceService {

    BalanceDto create(BalanceDto balanceDto);
    Balance update (Long id, double amount,double blockedAmount);
    Balance    findById(Long id);
}
