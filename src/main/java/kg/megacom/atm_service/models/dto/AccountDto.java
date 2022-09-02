package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.Balance;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {
    Long id;
    String account;
    BalanceDto balance;
}
