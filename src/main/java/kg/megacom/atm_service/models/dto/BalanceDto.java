package kg.megacom.atm_service.models.dto;


import kg.megacom.atm_service.emuns.BalanceStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class BalanceDto {


    Long id;
    BalanceStatus status;
}
