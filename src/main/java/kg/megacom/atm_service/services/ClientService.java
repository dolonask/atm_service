package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.models.entities.Client;

public interface ClientService {

    Client create (Client client);

    Client finById (Long id);

    Client update (Long id, Long limit);
}
