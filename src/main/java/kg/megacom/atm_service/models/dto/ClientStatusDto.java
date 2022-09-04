package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.emuns.ClientStatusName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class ClientStatusDto {


    Long id;
    ClientStatusName name;
}
