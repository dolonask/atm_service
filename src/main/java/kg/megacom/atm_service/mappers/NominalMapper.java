package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.NominalDto;
import kg.megacom.atm_service.models.entities.Nominal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NominalMapper extends CrudMapper<Nominal, NominalDto> {

    NominalMapper INSTANCE = Mappers.getMapper(NominalMapper.class);
}
