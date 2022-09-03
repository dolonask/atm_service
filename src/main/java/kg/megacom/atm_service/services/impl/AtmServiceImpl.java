package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.AtmRepo;
import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.services.AtmService;
import org.springframework.stereotype.Service;

@Service
public class AtmServiceImpl implements AtmService {

    private final AtmRepo atmRepo;

    public AtmServiceImpl(AtmRepo atmRepo) {
        this.atmRepo = atmRepo;
    }

    @Override
    public Atm findMoneyByAtm(Long id) {
        return atmRepo.findAtmById(id);
    }
}
