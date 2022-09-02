package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.responses.ResponseOne;
import kg.megacom.atm_service.services.AccountService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public ResponseOne login(@RequestBody RequestOne requestOne){
        return accountService.loginIntoAcc(requestOne);
    }
}
