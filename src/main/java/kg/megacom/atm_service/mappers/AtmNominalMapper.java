package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.AtmNominalDto;
import kg.megacom.atm_service.models.entities.AtmNominal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AtmNominalMapper extends CrudMapper<AtmNominal, AtmNominalDto> {

    AtmNominalMapper INSTANCE = Mappers.getMapper(AtmNominalMapper.class);
}
