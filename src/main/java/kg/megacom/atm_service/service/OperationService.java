package kg.megacom.atm_service.service;

import kg.megacom.atm_service.requests.BalanceRefillRequest;
import kg.megacom.atm_service.response.BalanceRefillResponse;

public interface OperationService {
    BalanceRefillResponse refillBalance(BalanceRefillRequest balanceRefillRequest);
}
