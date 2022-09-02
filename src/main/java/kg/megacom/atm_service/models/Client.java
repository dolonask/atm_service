package kg.megacom.atm_service.models;

import kg.megacom.atm_service.models.enums.ClientStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double withdrawalLimit;
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "client_status_id")
    private ClientStatus clientStatus;
}
