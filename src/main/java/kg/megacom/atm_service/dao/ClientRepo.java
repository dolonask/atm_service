package kg.megacom.atm_service.dao;

import kg.megacom.atm_service.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    @Query(value = "update clients set  limit = ?2 where id = ?1", nativeQuery = true)
    Client update(@Param("id") Long id, @Param("limit") Long limit);
}
