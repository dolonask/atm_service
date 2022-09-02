package kg.megacom.atm_service.repository;

import kg.megacom.atm_service.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends JpaRepository<Balance, Long> {
}
