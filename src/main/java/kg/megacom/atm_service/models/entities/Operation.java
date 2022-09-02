package kg.megacom.atm_service.models.entities;

import kg.megacom.atm_service.models.entities.enums.ClientStatus;
import kg.megacom.atm_service.models.entities.enums.OperationStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name="operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
            @JoinColumn(name="clients_id")
    Client client;
    @ManyToOne
    @JoinColumn(name="accounts_id")
    Account account;

    int amount;
    int operation_type;
    Date operation_date;

    @ManyToOne
    @JoinColumn(name="atms_id")
    Atm atm;


    @Enumerated(value = EnumType.STRING)
    OperationStatus operationStatus;



}
