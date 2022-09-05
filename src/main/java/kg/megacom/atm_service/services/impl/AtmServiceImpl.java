package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.AtmRepo;
import kg.megacom.atm_service.mappers.AtmMapper;
import kg.megacom.atm_service.models.dto.AtmDto;
import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.services.AtmService;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    private  final AtmRepo atmRepo;
    private  final AtmMapper atmMapper;

    public AtmServiceImpl(AtmRepo atmRepo) {
        this.atmRepo = atmRepo;
        this.atmMapper=AtmMapper.INSTANCE;
    }


    @Override
    public Atm createAmt(Atm atm) {

        return atmRepo.save(atm);
    }

    @Override
    public Atm findById(Long id) {
        return atmRepo.findById(id).orElseThrow(()-> new RuntimeException("Банкомат не найден!"));
    }
}
