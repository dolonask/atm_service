package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.response.AtmResponse;
import kg.megacom.atm_service.service.AtmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("atm")
public class AtmController {
    private final AtmService atmService;

    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/check-amount")
    AtmResponse checkTotal(){
        return atmService.checkTotalAmount();
    }

}
