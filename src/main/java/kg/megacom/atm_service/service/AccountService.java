package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.Balance;
import kg.megacom.atm_service.models.Client;
import kg.megacom.atm_service.models.enums.Currency;

public interface AccountService {
    Account createAccount(Client client, Currency currency);

    Balance checkBalance(Long accountId);

    void checkAvailableMoney(Long accountId, double amount);

}
