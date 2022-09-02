package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.AccountRepo;
import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.responses.ResponseOne;
import kg.megacom.atm_service.services.AccountService;
import kg.megacom.atm_service.services.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public ResponseOne loginIntoAcc(RequestOne requestOne) {

        return null;
    }
}
