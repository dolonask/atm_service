package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.enums.ClientStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)

public class ClientDto {



        Long id;
        String name;
        int limit;
        ClientStatus clientStatus;
        int amount;

    }
