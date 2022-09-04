package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper extends CrudMapper<Client, ClientDto> {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);


}
