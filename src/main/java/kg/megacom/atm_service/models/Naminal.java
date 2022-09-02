package kg.megacom.atm_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "naminals")
public class Naminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double fiveThousand = 5000;
    private double twoThousand = 2000;
    private double oneThousand = 1000;
    private double fiveHundred = 500;
    private double twoHundred = 200;
    private double oneHundred = 100;
    private double fifty = 50;
    private double twenty = 20;



}
