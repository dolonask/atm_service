package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.mappers.ClientMapper;
import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.repository.ClientRepo;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

private final ClientMapper clientMapper;
private final ClientRepo clientRepo;

    public ClientController(ClientService clientService,  ClientRepo clientRepo) {

        this.clientRepo = clientRepo;
        this.clientMapper = ClientMapper.INSTANCE;
    }
    @PostMapping("/save")
    public ClientDto save(@RequestBody ClientDto clientDto){
        Client client= clientMapper.toEntity(clientDto);
        client=clientRepo.save(client);
        return clientMapper.toDto(client);
    }
}
