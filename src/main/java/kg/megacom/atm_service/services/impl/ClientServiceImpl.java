package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.ClientRepo;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client save(Client client) {
        clientRepo.save(client);
        return client;
    }


}
