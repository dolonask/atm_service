package kg.megacom.atm_service.repository;

import kg.megacom.atm_service.models.entities.Atm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtmRepo extends JpaRepository<Atm,Long> {
}
