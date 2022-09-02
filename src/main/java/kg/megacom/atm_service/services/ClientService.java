package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.dto.requests.AuthorizationRequest;
import kg.megacom.atm_service.models.dto.responses.AuthorizationResponse;
import kg.megacom.atm_service.models.entities.Client;
import org.springframework.stereotype.Service;


public interface ClientService {
    public ClientDto save(ClientDto clientDto) ;
    AuthorizationResponse save(AuthorizationRequest authorizationRequest);

}
