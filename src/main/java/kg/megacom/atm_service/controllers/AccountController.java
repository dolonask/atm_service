package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.services.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    Account create (@RequestBody Account account) {return  accountService.create(account);}

}
