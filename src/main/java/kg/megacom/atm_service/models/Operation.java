package kg.megacom.atm_service.models;

import kg.megacom.atm_service.emuns.OperationStatus;
import kg.megacom.atm_service.emuns.OperationType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long amount;
    Date operationDate;

    @Enumerated(value = EnumType.STRING)
    OperationType operationType;

    @Enumerated(value = EnumType.STRING)
    OperationStatus operationStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "atm_id")
    Atm atm;



}
