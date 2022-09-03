package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/save")
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }
}
