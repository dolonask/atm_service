package kg.megacom.atm_service.models.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestOne {

    String accountNumber;
    int atmNumber;

}
