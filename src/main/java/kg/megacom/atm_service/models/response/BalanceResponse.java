package kg.megacom.atm_service.models.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BalanceResponse {


    double amount;
    double blockedAmount;
}
