package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.BalanceDto;
import kg.megacom.atm_service.models.entities.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper extends CrudMapper<Balance, BalanceDto> {

    BalanceMapper INSATANCE = Mappers.getMapper(BalanceMapper.class);
}
