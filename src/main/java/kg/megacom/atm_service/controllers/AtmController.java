package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.Balance;
import kg.megacom.atm_service.requests.RefillRequest;
import kg.megacom.atm_service.requests.WithdrawalRequest;
import kg.megacom.atm_service.response.RefillResponse;
import kg.megacom.atm_service.service.AccountService;
import kg.megacom.atm_service.service.AtmService;
import kg.megacom.atm_service.service.OperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atm")
public class AtmController {
    private final AtmService atmService;
    private final AccountService accountService;

    public AtmController(AtmService atmService, AccountService accountService, OperationService operationService) {
        this.atmService = atmService;
        this.accountService = accountService;
    }

    //проверка
    @GetMapping("/check-amount")
    double checkTotal(){
        return atmService.checkTotalAmount();
    }
    //авторизация и проверка баланса клиента
    @GetMapping("/check-account")
    Balance  checkBalanceInAccount(@RequestParam Long accountId){
        return accountService.checkBalance(accountId);
    }

}
