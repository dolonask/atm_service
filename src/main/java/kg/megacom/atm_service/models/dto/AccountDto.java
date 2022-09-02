package kg.megacom.atm_service.models.dto;

import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.models.entities.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AccountDto {


        Long id;
        String account;

        ClientDto client;

        BalanceDto balance;

    }


