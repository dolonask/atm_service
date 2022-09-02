package kg.megacom.atm_service.repository;

import kg.megacom.atm_service.models.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepo extends JpaRepository<Atm, Long> {
}
