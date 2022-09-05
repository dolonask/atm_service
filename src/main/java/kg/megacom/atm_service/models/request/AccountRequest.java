package kg.megacom.atm_service.models.request;

import kg.megacom.atm_service.models.dto.AccountDto;
import kg.megacom.atm_service.models.dto.BalanceDto;
import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.dto.ClientStatusDto;
import kg.megacom.atm_service.models.entities.Account;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class AccountRequest {

    AccountDto accountDto;
    ClientDto clientDto;
    BalanceDto balanceDto;
    ClientStatusDto clientStatusDto;

}
