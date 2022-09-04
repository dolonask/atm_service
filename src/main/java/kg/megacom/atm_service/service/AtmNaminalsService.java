package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.AtmNominal;
import kg.megacom.atm_service.models.Naminal;
import kg.megacom.atm_service.repository.AtmNominalsRepo;
import kg.megacom.atm_service.repository.NaminalRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtmNaminalsService {
    private final AtmNominalsRepo atmNominalsRepo;
    private final NaminalService naminalService;
    private final NaminalRepo naminalRepo;

    public AtmNaminalsService(AtmNominalsRepo atmNominalsRepo, NaminalService naminalService, NaminalRepo naminalRepo) {
        this.atmNominalsRepo = atmNominalsRepo;
        this.naminalService = naminalService;
        this.naminalRepo = naminalRepo;
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

    //добавление наминалов в банкомат
    public void addNaminals(List<Double> naminals) {
        for (int i = 0; i< naminals.size(); i++){
            Long id = naminalService.findByNaminals(naminals.get(i));
            AtmNominal atmNominal = atmNominalsRepo.findByNaminalId(id);
            atmNominal.setAmount(atmNominal.getAmount()+1);
            atmNominalsRepo.save(atmNominal);
        }
    }

    //выдача денег банкоматом
    public List<Double> withDrawNaminals(double amount) {

        List<Double> naminals = new ArrayList<>();
        double money = amount;
        for (long i = 1; i <= 8;i++){
            AtmNominal atmNominal = atmNominalsRepo.findById(i).orElseThrow();
            Naminal naminal = naminalRepo.findById(i).orElseThrow();
            for (int j = 0; j < money; j++){
            if (atmNominal.getAmount() > 0 && naminal.getNaminals() <= money) {
                atmNominal.setAmount(atmNominal.getAmount() - 1);
                money -= naminal.getNaminals();
                naminals.add(naminal.getNaminals());
                atmNominalsRepo.save(atmNominal);
            }
            }

        }
        return naminals;
    }
}
