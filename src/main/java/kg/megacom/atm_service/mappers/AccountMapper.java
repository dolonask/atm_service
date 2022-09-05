package kg.megacom.atm_service.mappers;

import kg.megacom.atm_service.mappers.base.CrudMapper;
import kg.megacom.atm_service.models.dto.AccountDto;
import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.request.AccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends CrudMapper<Account, AccountDto> {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountRequestToAccount(AccountRequest accountRequest);

}
