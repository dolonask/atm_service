package kg.megacom.atm_service.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "atms_nominal")
public class AtmNominal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int amount;
    @ManyToOne
    @JoinColumn(name = "atm_id")
    Atm atm;

    @ManyToOne
    @JoinColumn(name = "nominal_id")
    Nominal nominal;

}
