package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.AccountRepo;
import kg.megacom.atm_service.mappers.AccountMapper;
import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.request.AccountRequest;
import kg.megacom.atm_service.models.response.AccountResponse;
import kg.megacom.atm_service.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private  final AccountRepo accountRepo;
    private  final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
        this.accountMapper = AccountMapper.INSTANCE;
    }

    @Override
    public Account create(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public AccountResponse createNew(AccountRequest accountRequest) {

        Account account = accountMapper.accountRequestToAccount(accountRequest);



        return null;
    }
}
