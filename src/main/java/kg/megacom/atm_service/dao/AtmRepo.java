package kg.megacom.atm_service.dao;

import kg.megacom.atm_service.models.entities.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepo extends JpaRepository<Atm, Long> {
    Atm findAtmById(Long id);

    //List<Atm>findByAtmNumber
}
