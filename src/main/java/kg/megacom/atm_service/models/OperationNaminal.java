package kg.megacom.atm_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operation_naminals")
public class OperationNaminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;
    @ManyToOne
    @JoinColumn(name = "naminal_id")
    private Naminal naminal;
    private double amount;
}
