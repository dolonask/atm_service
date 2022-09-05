package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.requests.RequestWithdraw;
import kg.megacom.atm_service.models.responses.ResponseOne;
import kg.megacom.atm_service.models.responses.ResponseWithdraw;
import kg.megacom.atm_service.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }
    @GetMapping("/login")
    public ResponseOne login(@RequestBody RequestOne requestOne){
        return accountService.loginIntoAcc(requestOne);
    }

    @GetMapping("/withdraw")
    public ResponseWithdraw login(@RequestBody RequestWithdraw requestWithdraw){
        return accountService.withdrawMoney(requestWithdraw);
    }
}
