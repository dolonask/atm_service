package kg.megacom.atm_service.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name="atm_nominals")
public class AtmNominal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name="atms_id")
    Atm atm;
    @ManyToOne
    @JoinColumn(name="nominals_id")
    Nominal nominal;
    int amount;


}
