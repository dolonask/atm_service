package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.models.entities.Nominal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtmNominalDto {
    Long id;
    AtmDto atm;
    NominalDto nominal;

}
