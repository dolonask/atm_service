package kg.megacom.atm_service.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String account;

    @OneToOne
    @JoinColumn(name = "client_id")
    Client client;

    @OneToOne
    @JoinColumn(name = "balance_id")
    Balance balance;
}