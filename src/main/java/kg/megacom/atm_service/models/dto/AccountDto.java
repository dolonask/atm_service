package kg.megacom.atm_service.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class AccountDto {


    Long id;
    Long account;

    ClientDto client;
    BalanceDto balance;


}
