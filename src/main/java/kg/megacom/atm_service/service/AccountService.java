package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.Balance;
import kg.megacom.atm_service.models.Client;
import kg.megacom.atm_service.models.enums.Currency;
import kg.megacom.atm_service.requests.TransferRequest;

public interface AccountService {
    Account createAccount(Client client, Currency currency);

    Balance checkBalance(Long accountId);

    void checkAvailableMoney(Long accountId, double amount);

    void removeBlockedAmount(Long accountId, double amount);

    void moneyTransfer(TransferRequest transferRequest);
}
