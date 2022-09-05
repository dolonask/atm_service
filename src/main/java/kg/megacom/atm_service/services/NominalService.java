package kg.megacom.atm_service.services;

import kg.megacom.atm_service.models.dto.NominalDto;
import kg.megacom.atm_service.models.entities.Nominal;

public interface NominalService {

    NominalDto createNewNominal (NominalDto nominalDto);
    Nominal findById (Long id);

}
