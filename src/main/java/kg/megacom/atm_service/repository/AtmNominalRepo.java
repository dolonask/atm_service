package kg.megacom.atm_service.repository;

import kg.megacom.atm_service.models.entities.AtmNominal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmNominalRepo extends JpaRepository<AtmNominal,Long> {
}
