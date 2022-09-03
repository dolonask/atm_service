package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.models.requests.RequestOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AtmMapper {
    AtmMapper INSTANCE = Mappers.getMapper(AtmMapper.class);
    //@Mapping(source = "atmNumber", target = "atm_id")
    Atm requestOneToAtm(RequestOne requestOne);
}
