package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping("/create")
    Client create (@RequestBody Client client) {return service.create(client); }

    @GetMapping("/get")
    Client getById (@RequestParam Long id) {return  service.finById(id);}


}
