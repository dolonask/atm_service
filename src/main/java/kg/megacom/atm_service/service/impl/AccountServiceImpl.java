package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.Balance;
import kg.megacom.atm_service.models.Client;
import kg.megacom.atm_service.models.enums.Currency;
import kg.megacom.atm_service.repository.AccountRepo;
import kg.megacom.atm_service.repository.BalanceRepo;
import kg.megacom.atm_service.repository.ClientRepo;
import kg.megacom.atm_service.service.AccountService;
import kg.megacom.atm_service.service.BalanceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final BalanceService balanceService;
    private final ClientRepo clientRepo;
    private final BalanceRepo balanceRepo;

    public AccountServiceImpl(AccountRepo accountRepo, BalanceService balanceService, ClientRepo clientRepo, BalanceRepo balanceRepo) {
        this.accountRepo = accountRepo;
        this.balanceService = balanceService;
        this.clientRepo = clientRepo;
        this.balanceRepo = balanceRepo;
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

    @Override
    public void checkAvailableMoney(Long accountId, double amount) {

        Account account = accountRepo.findById(accountId).orElseThrow();
        Client client = clientRepo.findById(account.getClients().getId()).orElseThrow();
        Balance balance = balanceRepo.findById(account.getBalance().getId()).orElseThrow();

        if (balance.getAmount() < amount) throw new RuntimeException("у вас не достаточно средств для снятие!");
        if (client.getWithdrawalLimit() >= amount){
            client.setWithdrawalLimit(client.getWithdrawalLimit() - amount);
            clientRepo.save(client);
        }else if (client.getWithdrawalLimit()==0) throw new RuntimeException("у вас окончился лимит на снятие!");
        else throw new RuntimeException("вы можете снять только " + client.getWithdrawalLimit());
        //блокировка баланса
        balance.setAmount(balance.getAmount()-amount);
        balance.setBlockedAmount(balance.getBlockedAmount() + amount);
        balanceRepo.save(balance);
    }

    @Override
    public void removeBlockedAmount(Long accountId, double amount) {
        Account account = accountRepo.findById(accountId).orElseThrow();
        Balance balance = balanceRepo.findById(account.getBalance().getId()).orElseThrow();
        balance.setBlockedAmount(balance.getBlockedAmount()-amount);
    }
}
