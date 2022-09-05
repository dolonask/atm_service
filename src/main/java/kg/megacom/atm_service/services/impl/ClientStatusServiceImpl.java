package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.ClientStatusRepo;
import kg.megacom.atm_service.mappers.ClientStatusMapper;
import kg.megacom.atm_service.models.dto.ClientStatusDto;
import kg.megacom.atm_service.models.entities.ClientStatus;
import kg.megacom.atm_service.services.ClientStatusService;
import org.springframework.stereotype.Service;

@Service
public class ClientStatusServiceImpl implements ClientStatusService {
    private final ClientStatusMapper clientStatusMapper;
    private final ClientStatusRepo clientStatusRepo;

    public ClientStatusServiceImpl(ClientStatusRepo clientStatusRepo) {
        this.clientStatusMapper = ClientStatusMapper.INSTANCE;
        this.clientStatusRepo = clientStatusRepo;
    }

    @Override
    public ClientStatusDto create(ClientStatusDto clientStatusDto) {
        ClientStatus clientStatus = clientStatusMapper.toEntity(clientStatusDto);
        clientStatus = clientStatusRepo.save(clientStatus);
        return clientStatusMapper.toDto(clientStatus);
    }

    @Override
    public ClientStatus findById(Long id) {
        return clientStatusRepo.findById(id).orElseThrow(()-> new RuntimeException("Статус Клиента не найден!"));
    }
}
