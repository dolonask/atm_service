package kg.megacom.atm_service.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "atms")
public class Atm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String atm;

    Long amount;
}
