package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.Naminal;
import kg.megacom.atm_service.requests.BalanceRefillRequest;
import kg.megacom.atm_service.requests.WithdrawalRequest;
import kg.megacom.atm_service.response.BalanceRefillResponse;

import java.util.List;

public interface OperationService {
    BalanceRefillResponse refillBalance(BalanceRefillRequest balanceRefillRequest);

    List<Double> cashWithdraw(WithdrawalRequest withdrawalRequest);
}
