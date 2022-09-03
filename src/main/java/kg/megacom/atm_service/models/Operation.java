package kg.megacom.atm_service.models;

import kg.megacom.atm_service.models.enums.OperationStatus;
import kg.megacom.atm_service.models.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client clients;
    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account account;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    @DateTimeFormat(pattern = "dd,mm,yyyy")
    private Date operationDate;
    @ManyToOne
    @JoinColumn(name = "atm_id")
    private Atm atm;
    @Enumerated(EnumType.STRING)
    private OperationStatus operationStatus;
}
