package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.AccountRepo;
import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.responses.ResponseOne;
import kg.megacom.atm_service.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;


    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account save(Account account){
        return accountRepo.save(account);
    }

    @Override
    public ResponseOne loginIntoAcc(RequestOne requestOne) {
        Account account = findByNumber(requestOne.getAccountNumber());
        ResponseOne responseOne = new ResponseOne();
        responseOne.setAvailableAmount(account.getBalance().getAmount()-account.getBalance().getBlockedAmount());
        responseOne.setBlockedAmount(account.getBalance().getBlockedAmount());

        return responseOne;
    }

    @Override
    public Account findByNumber(String accNumber){
        return accountRepo.findByAccountNumber(accNumber);
    }
}
