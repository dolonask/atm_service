package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.responses.ResponseOne;

public interface AccountService {
    ResponseOne loginIntoAcc(RequestOne requestOne);
}
