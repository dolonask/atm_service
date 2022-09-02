package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.ClientStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {
    Long id;
    String name;
    Long limit;

    ClientStatusDto clientStatus;
}
