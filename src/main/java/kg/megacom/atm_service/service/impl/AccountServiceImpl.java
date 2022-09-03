package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.Balance;
import kg.megacom.atm_service.models.Client;
import kg.megacom.atm_service.models.enums.Currency;
import kg.megacom.atm_service.repository.AccountRepo;
import kg.megacom.atm_service.service.AccountService;
import kg.megacom.atm_service.service.BalanceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final BalanceService balanceService;

    public AccountServiceImpl(AccountRepo accountRepo, BalanceService balanceService) {
        this.accountRepo = accountRepo;
        this.balanceService = balanceService;
    }


    @Override
    public Account createAccount(Client client, Currency currency) {

        Balance  balance  = balanceService.createBalance();

        Account account = new Account();
        account.setClients(client);
        account.setBalance(balance);
        account.setCurrency(currency);
        accountRepo.save(account);
        return account;
    }

    @Override
    public Balance checkBalance(Long accountId) {
        Optional<Account> account = accountRepo.findById(accountId);
        return account.get().getBalance();
    }
}
