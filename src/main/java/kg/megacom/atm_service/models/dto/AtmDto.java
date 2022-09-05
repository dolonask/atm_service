package kg.megacom.atm_service.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class AtmDto {


    Long id;
    Long atm;
    Long amount;
}
