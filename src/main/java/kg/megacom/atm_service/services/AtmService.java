package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.dto.AtmDto;
import kg.megacom.atm_service.models.entities.Atm;

public interface AtmService {

    Atm createAmt (Atm atm);
    Atm findById (Long id);
}
