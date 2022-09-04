package kg.megacom.atm_service.models.entities;


import kg.megacom.atm_service.emuns.BalanceStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double amount;
    @Enumerated(value = EnumType.STRING)
    BalanceStatus status;
}
