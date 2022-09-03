package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.models.requests.RequestOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper {

    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    //@Mapping(source = "atmNumber", target = "atm.id")
    Balance requestOneToBalance(RequestOne requestOne);
}
