package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.dto.ClientStatusDto;
import kg.megacom.atm_service.services.ClientStatusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/clientStatus")
public class ClientStatusController {

    private final ClientStatusService clientStatusService;


    public ClientStatusController(ClientStatusService clientStatusService) {
        this.clientStatusService = clientStatusService;
    }

    @PostMapping("/create")
    public ClientStatusDto create (@RequestBody ClientStatusDto clientStatusDto) {return clientStatusService.create(clientStatusDto);}
}
