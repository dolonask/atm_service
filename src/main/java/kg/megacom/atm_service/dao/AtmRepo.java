package kg.megacom.atm_service.dao;

import kg.megacom.atm_service.models.entities.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepo extends JpaRepository<Atm, Long> {
    Atm findAtmById(Long id);
}
