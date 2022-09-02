package kg.megacom.atm_service.models.entities;

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
    @ManyToOne
    @JoinColumn(name = "operations_id")
    Operation operation;

    @ManyToOne
    @JoinColumn(name = "nominals_id")
    Nominal nominal;

    int amount;

}
