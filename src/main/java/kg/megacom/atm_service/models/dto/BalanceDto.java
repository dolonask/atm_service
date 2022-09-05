package kg.megacom.atm_service.models.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class BalanceDto {


    Long id;
    double amount;
    double blockedAmount;
}
