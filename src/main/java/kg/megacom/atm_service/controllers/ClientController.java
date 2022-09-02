package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.enums.Currency;
import kg.megacom.atm_service.service.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/create")
    public Account clientRegistration(@RequestParam String name,
                                      @RequestParam double limit,
                                      @RequestParam Currency currency){
        return  clientService.clientRegistration(name, limit, currency);
    }
}
