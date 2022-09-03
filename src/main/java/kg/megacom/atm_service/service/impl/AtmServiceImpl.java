package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Atm;
import kg.megacom.atm_service.repository.AtmRepo;
import kg.megacom.atm_service.service.AtmNaminalsService;
import kg.megacom.atm_service.service.AtmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private final AtmNaminalsService atmNaminalsService;
    private final AtmRepo atmRepo;

    public AtmServiceImpl(AtmNaminalsService atmNaminalsService, AtmRepo atmRepo) {
        this.atmNaminalsService = atmNaminalsService;
        this.atmRepo = atmRepo;
    }


    @Override
    public double checkTotalAmount() {
        return atmNaminalsService.getTotal();
    }

    @Override
    public void addMoneyFromRefill(Long atmId, double amount, List<Double> naminals) {
        //сохранить изминение в атм
        Atm atm = atmRepo.findById(atmId).orElseThrow();
        atm.setAmount(atm.getAmount()+amount);
        atmRepo.save(atm);
        //добавление наминалов в атм наминал
        atmNaminalsService.addNaminals(naminals);



    }
}
