package kg.megacom.atm_service.repository;

import kg.megacom.atm_service.models.Naminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaminalRepo extends JpaRepository<Naminal, Long> {
}
