package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.dto.requests.AuthorizationRequest;
import kg.megacom.atm_service.models.dto.responses.AuthorizationResponse;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.repository.ClientRepo;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }



    @Override
    public ClientDto save(ClientDto clientDto) {
        return null;
    }

    @Override
    public AuthorizationResponse save(AuthorizationRequest authorizationRequest) {
        return null;
    }
}
