package kg.megacom.atm_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "atm_naminals")
public class AtmNominal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "atm_id")
    private Atm atm;
    @ManyToOne
    @JoinColumn(name = "naminal_id")
    private Naminal naminal;
    private double amount;
}
