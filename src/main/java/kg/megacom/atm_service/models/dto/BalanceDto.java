package kg.megacom.atm_service.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)

public class BalanceDto {
        Long id;
        int amount;
        int  blocked_amount;
}
