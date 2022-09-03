package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Atm;
import kg.megacom.atm_service.models.Naminal;
import kg.megacom.atm_service.repository.AtmNominalsRepo;
import kg.megacom.atm_service.repository.AtmRepo;
import kg.megacom.atm_service.service.AtmNaminalsService;
import kg.megacom.atm_service.service.AtmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private final AtmNaminalsService atmNaminalsService;
    private final AtmRepo atmRepo;
    private final AtmNominalsRepo atmNominalsRepo;

    public AtmServiceImpl(AtmNaminalsService atmNaminalsService, AtmRepo atmRepo, AtmNominalsRepo atmNominalsRepo) {
        this.atmNaminalsService = atmNaminalsService;
        this.atmRepo = atmRepo;
        this.atmNominalsRepo = atmNominalsRepo;
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

    @Override
    public void checkAvailableAmount(Long atmId, double amount) {
        Atm atm = atmRepo.findById(atmId).orElseThrow();
        if (atm.getAmount() < amount) throw  new RuntimeException("не достатчно денег для снятия в бакомате");
    }

    @Override
    public List<Double> withdrawMoney(Long atmId, double amount) {
        //минус снимаемая сумма из банкомата
        Atm atm = atmRepo.findById(atmId).orElseThrow();
        atm.setAmount(atm.getAmount() - amount);
        atmRepo.save(atm);
        //минус наминалов из атм наминалс
        List<Double> naminals = atmNaminalsService.withDrawNaminals(amount);
        return naminals;
    }

}
