package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Account;
import kg.megacom.atm_service.models.Client;
import kg.megacom.atm_service.models.enums.ClientStatus;
import kg.megacom.atm_service.models.enums.Currency;
import kg.megacom.atm_service.repository.ClientRepo;
import kg.megacom.atm_service.service.AccountService;
import kg.megacom.atm_service.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final AccountService accountService;

    public ClientServiceImpl(ClientRepo clientRepo, AccountService accountService) {
        this.clientRepo = clientRepo;
        this.accountService = accountService;
    }

    @Override
    public Account clientRegistration(String name, double limit,  Currency currency) {

        //creating a client

        Client client = new Client();
        if(!clientRepo.existsByName(name)) {
            client.setName(name);
            client.setWithdrawalLimit(limit);
            client.setClientStatus(ClientStatus.DEACTIVATED);
            clientRepo.save(client);
        }else throw new RuntimeException("клиент уже зарегестрирован!");


        return  accountService.createAccount(client, currency);
    }
}
