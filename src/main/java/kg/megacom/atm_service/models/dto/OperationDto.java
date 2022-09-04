package kg.megacom.atm_service.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.atm_service.emuns.OperationStatus;
import kg.megacom.atm_service.emuns.OperationType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class OperationDto {


    Long id;
    Long amount;

    @JsonFormat(pattern = "dd.MM.yyyy")
    Date operationDate;

    OperationType operationType;
    OperationStatus operationStatus;

    ClientDto client;
    AccountDto account;
    AtmDto atm;



}
