package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.request.AccountRequest;
import kg.megacom.atm_service.models.response.AccountResponse;

public interface AccountService {

    Account create (Account account);
    Account update (Account account);
    AccountResponse createNew (AccountRequest accountRequest);


}
