package kg.megacom.atm_service.models.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestWithdraw {

    String accountNumber;
    int atmNumber;
    int money;

}
