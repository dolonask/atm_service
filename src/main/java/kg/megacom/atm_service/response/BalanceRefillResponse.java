package kg.megacom.atm_service.response;

import kg.megacom.atm_service.models.Balance;
import lombok.Data;

@Data
public class BalanceRefillResponse {
    private String operationStatus;
    private Balance balance;
}
