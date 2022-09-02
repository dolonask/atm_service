package kg.megacom.atm_service.response;

import lombok.Data;

@Data
public class AtmResponse {
    private String naminal;
    private double amount;
    private double total;

}
