package kg.megacom.atm_service.mappers;
import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.dto.requests.AuthorizationRequest;
import kg.megacom.atm_service.models.entities.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper

public interface ClientMapper extends CrudMapper<Client, ClientDto> {


        ClientMapper INSTANCE= Mappers.getMapper(ClientMapper.class);

        Client toEntity(ClientDto categoryDto);
        @InheritInverseConfiguration
        ClientDto toDto(Client category);
        @Mapping(source = "clientId", target = "id")
        @Mapping(source = "", target = "")
        Client authorizationRequestToClient(AuthorizationRequest authorizationRequest);

}
