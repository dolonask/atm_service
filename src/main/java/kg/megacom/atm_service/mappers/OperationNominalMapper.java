package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.OperationNominalDto;
import kg.megacom.atm_service.models.entities.OperationNominal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationNominalMapper extends CrudMapper<OperationNominal, OperationNominalDto> {

    OperationNominalMapper INSTANCE = Mappers.getMapper(OperationNominalMapper.class);
}
