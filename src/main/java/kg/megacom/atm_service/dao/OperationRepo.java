package kg.megacom.atm_service.dao;

import kg.megacom.atm_service.models.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepo extends JpaRepository<Operation, Long> {
}
