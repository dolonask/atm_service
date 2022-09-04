package kg.megacom.atm_service.service;

import kg.megacom.atm_service.requests.RefillRequest;
import kg.megacom.atm_service.requests.TransferRequest;
import kg.megacom.atm_service.requests.WithdrawalRequest;
import kg.megacom.atm_service.response.RefillResponse;
import kg.megacom.atm_service.response.TransferResponse;

import java.util.List;

public interface OperationService {
    RefillResponse refillBalance(RefillRequest refillRequest);

    List<Double> cashWithdraw(WithdrawalRequest withdrawalRequest);

    TransferResponse transfer(TransferRequest transferRequest);
}
