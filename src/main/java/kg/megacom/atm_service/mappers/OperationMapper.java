package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.OperationDto;
import kg.megacom.atm_service.models.entities.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper extends CrudMapper<Operation, OperationDto> {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

}
