package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.AtmDto;
import kg.megacom.atm_service.models.entities.Atm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AtmMapper extends CrudMapper<Atm, AtmDto> {

    AtmMapper INSTANCE = Mappers.getMapper(AtmMapper.class);

}
