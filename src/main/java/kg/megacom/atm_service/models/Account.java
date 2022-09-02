package kg.megacom.atm_service.models;

import kg.megacom.atm_service.models.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Enumerated(EnumType.STRING)
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client clients;
    @ManyToOne
    @JoinColumn(name = "balances_id")
    private Balance balance;
}
