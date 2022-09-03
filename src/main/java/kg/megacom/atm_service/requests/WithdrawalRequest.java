package kg.megacom.atm_service.requests;

import lombok.Data;

@Data
public class WithdrawalRequest {
    private Long accountId;
    private Long atmId;
    private double amount;
}
