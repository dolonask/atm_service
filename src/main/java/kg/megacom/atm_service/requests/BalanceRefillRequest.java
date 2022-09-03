package kg.megacom.atm_service.requests;

import lombok.Data;

import java.util.List;
@Data
public class BalanceRefillRequest {

    private Long accountId;
    private Long atmId;
    private double amount;
    private List<Double> naminals;
}
