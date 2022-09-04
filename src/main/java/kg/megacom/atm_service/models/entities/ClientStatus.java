package kg.megacom.atm_service.models.entities;

import kg.megacom.atm_service.emuns.ClientStatusName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "client_statuses")
public class ClientStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(value = EnumType.STRING)
    ClientStatusName name;
}
