package kg.megacom.atm_service.models;

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
    Long account;

    @ManyToOne
    @JoinColumn (name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn (name = "balance_id")
    Balance balance;


}
