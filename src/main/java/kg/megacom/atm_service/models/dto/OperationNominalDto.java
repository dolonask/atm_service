package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.Nominal;
import kg.megacom.atm_service.models.entities.Operation;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationNominalDto {
    Long id;

    OperationDto operation;

    NominalDto nominal;
}
