package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.entities.Atm;

public interface AtmService {
    Atm findMoneyByAtm(Long id);
}
