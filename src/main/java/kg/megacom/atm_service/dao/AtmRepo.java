package kg.megacom.atm_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepo extends JpaRepository<AtmRepo, Long> {


}
