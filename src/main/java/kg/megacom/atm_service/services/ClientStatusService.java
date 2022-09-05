package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.dto.ClientStatusDto;
import kg.megacom.atm_service.models.entities.ClientStatus;

public interface ClientStatusService {

    ClientStatusDto create (ClientStatusDto clientStatusDto);

    ClientStatus findById (Long id);
}
