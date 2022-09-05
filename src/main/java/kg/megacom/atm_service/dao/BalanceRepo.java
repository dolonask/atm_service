package kg.megacom.atm_service.dao;

import kg.megacom.atm_service.models.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.SpelQueryContext;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends JpaRepository<Balance, Long> {

    @Query (value = "update balances set  amount = ?2, blockedAmount = ?3 where id = ?1", nativeQuery = true)
    Balance update(@Param("id") Long id, @Param("amount") double amount,@Param("blockedAmount") double blockedAmount);
}
