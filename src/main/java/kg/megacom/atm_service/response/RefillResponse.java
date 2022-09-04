package kg.megacom.atm_service.response;

import kg.megacom.atm_service.models.Balance;
import lombok.Data;

@Data
public class RefillResponse {
    private String operationStatus;
    private Balance balance;
}
