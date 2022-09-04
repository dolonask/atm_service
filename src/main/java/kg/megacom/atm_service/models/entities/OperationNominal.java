package kg.megacom.atm_service.models.entities;

import kg.megacom.atm_service.models.entities.Nominal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "operation_nominals")
public class OperationNominal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    Long amount;

    @ManyToOne
    @JoinColumn(name = "nominal_id")
    Nominal nominal;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    Operation operation;
}
