package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.models.entities.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperationDto {
    Long id;
    Long amount;
    String operationType;
    Date operationDate;
    String status;

    ClientDto client;

    AccountDto account;

    AtmDto atm;

}
