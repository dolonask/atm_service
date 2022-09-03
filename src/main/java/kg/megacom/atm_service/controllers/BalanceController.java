package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.services.BalanceService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("v1/balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/get")
    public Balance getBalance(@RequestParam Long balanceId){
        return balanceService.getBalanceById(balanceId);
    }

}
