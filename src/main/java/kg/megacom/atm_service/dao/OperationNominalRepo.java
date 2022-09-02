package kg.megacom.atm_service.dao;

import kg.megacom.atm_service.models.entities.OperationNominal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationNominalRepo extends JpaRepository<OperationNominal, Long> {
}
