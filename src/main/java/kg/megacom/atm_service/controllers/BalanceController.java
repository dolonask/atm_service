package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.dto.BalanceDto;
import kg.megacom.atm_service.services.BalanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/balance")
public class BalanceController {

    private final BalanceService balanceService;


    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping("/create")
    public BalanceDto create (@RequestBody BalanceDto balanceDto) {return balanceService.create(balanceDto);}

}
