package kg.megacom.atm_service.response;

import kg.megacom.atm_service.models.Account;
import lombok.Data;

@Data
public class TransferResponse {
    private Account fromAccount;
    private Account toAccount;
}
