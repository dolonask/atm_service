package kg.megacom.atm_service.models.responses;

import kg.megacom.atm_service.models.dto.BalanceDto;
import kg.megacom.atm_service.models.entities.Balance;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseOne {
    Balance amount;
}
