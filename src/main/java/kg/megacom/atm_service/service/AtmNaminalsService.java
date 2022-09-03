package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.AtmNominal;
import kg.megacom.atm_service.repository.AtmNominalsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmNaminalsService {
    private final AtmNominalsRepo atmNominalsRepo;
    private final NaminalService naminalService;

    public AtmNaminalsService(AtmNominalsRepo atmNominalsRepo, NaminalService naminalService) {
        this.atmNominalsRepo = atmNominalsRepo;
        this.naminalService = naminalService;
    }

    //колличество денег в банкомате
    public double getTotal(){
        List<AtmNominal> atmNominals =  atmNominalsRepo.findAllByAtmId(1L);
        double total = 0;
        for (AtmNominal nominal : atmNominals) {
            AtmNominal atmNominal = new AtmNominal();
            atmNominal.setAmount(nominal.getAmount());
            atmNominal.setNaminal(nominal.getNaminal());
            total += atmNominal.getAmount() * atmNominal.getNaminal().getNaminals();

        }
        return total;
    }

    public void addNaminals(List<Double> naminals) {
        for (int i = 0; i< naminals.size(); i++){
            Long id = naminalService.findByNaminals(naminals.get(i));
            AtmNominal atmNominal = atmNominalsRepo.findByNaminalId(id);
            atmNominal.setAmount(atmNominal.getAmount()+1);
            atmNominalsRepo.save(atmNominal);
        }
    }
}
