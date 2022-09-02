package kg.megacom.atm_service.models.entities;

import kg.megacom.atm_service.models.entities.enums.ClientStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name = "clients")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    double limitOfMoney;



    @Enumerated(value = EnumType.STRING)
    ClientStatus clientStatus;


}

