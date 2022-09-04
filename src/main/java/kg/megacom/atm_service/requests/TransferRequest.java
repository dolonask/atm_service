package kg.megacom.atm_service.requests;

import lombok.Data;

@Data
public class TransferRequest {
    private Long fromAccount;
    private Long toAccount;
    private double amount;
}
