package kg.megacom.atm_service.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Long clientLimit;

    @ManyToOne
    @JoinColumn(name = "client_status_id")

    ClientStatus clientStatus;
}
