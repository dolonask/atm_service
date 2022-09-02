package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.models.entities.enums.OperationStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class OperationDto {

        Long id;
        Client client;
        Account account;
        int amount;
        int operation_type;
        Date operation_date;
        Atm atm;
        OperationStatus operationStatus;
}
