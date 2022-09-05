package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.ClientRepo;
import kg.megacom.atm_service.mappers.ClientMapper;
import kg.megacom.atm_service.models.dto.ClientDto;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
        this.clientMapper = ClientMapper.INSTANCE;
    }

    @Override
    public Client create(Client client) {

        return clientRepo.save(client);
    }

    @Override
    public Client finById(Long id) {
        return clientRepo.findById(id).orElseThrow(()-> new RuntimeException("Такой клиентне найден!"));
    }

    @Override
    public Client update(Long id, Long limit) {
        return clientRepo.update(id,limit);
    }
}
