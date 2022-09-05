package kg.megacom.atm_service.models.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults (level =  AccessLevel.PRIVATE)
public class AccountResponse {

    Long account;
    String clientName;
    Long clientLimit;
    Long clientStatusId;
    Long amount;
    Long blockedAmount;


    /*

    "id": 1,
    "account": 123,

    "client": {
        "id": 1,
        "name": null,
        "clientLimit": null,
        "clientStatus": null
    },
    "balance": {
        "id": 1,
        "amount": 0.0,
        "blockedAmount": 0.0
     */
}
