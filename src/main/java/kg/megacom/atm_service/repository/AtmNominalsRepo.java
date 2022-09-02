package kg.megacom.atm_service.repository;

import kg.megacom.atm_service.models.AtmNominal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmNominalsRepo extends JpaRepository<AtmNominal,Long> {
}
