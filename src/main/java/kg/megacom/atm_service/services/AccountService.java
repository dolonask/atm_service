package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.requests.RequestWithdraw;
import kg.megacom.atm_service.models.responses.ResponseOne;
import kg.megacom.atm_service.models.responses.ResponseWithdraw;

public interface AccountService {
    ResponseOne loginIntoAcc(RequestOne requestOne);
    Account save(Account account);

    public Account findByNumber(String accNumber);

    ResponseWithdraw withdrawMoney(RequestWithdraw requestWithdraw);
}
