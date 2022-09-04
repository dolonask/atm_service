package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.ClientStatusDto;
import kg.megacom.atm_service.models.entities.ClientStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientStatusMapper extends CrudMapper<ClientStatus, ClientStatusDto> {

    ClientStatusMapper INSTANCE = Mappers.getMapper(ClientStatusMapper.class);
}
