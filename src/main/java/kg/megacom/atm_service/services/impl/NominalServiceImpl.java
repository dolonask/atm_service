package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.NominalRepo;
import kg.megacom.atm_service.mappers.NominalMapper;
import kg.megacom.atm_service.models.dto.NominalDto;
import kg.megacom.atm_service.models.entities.Nominal;
import kg.megacom.atm_service.services.NominalService;
import org.springframework.stereotype.Service;

@Service
public class NominalServiceImpl implements NominalService {

    private final NominalRepo nominalRepo;
    private final NominalMapper nominalMapper;

    public NominalServiceImpl(NominalRepo nominalRepo) {
        this.nominalRepo = nominalRepo;
        this.nominalMapper =NominalMapper.INSTANCE;
    }

    @Override
    public NominalDto createNewNominal (NominalDto nominalDto) {
        Nominal nominal = nominalMapper.toEntity(nominalDto);
        nominal = nominalRepo.save(nominal);
        return nominalMapper.toDto(nominal);
    }

    @Override
    public Nominal findById(Long id) {
        return nominalRepo.findById(id).orElseThrow(()-> new RuntimeException("Указанный номенал не найден или пуст!"));
    }
}
