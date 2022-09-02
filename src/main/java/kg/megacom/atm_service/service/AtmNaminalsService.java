package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.AtmNominal;
import kg.megacom.atm_service.repository.AtmNominalsRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtmNaminalsService {
    private final AtmNominalsRepo atmNominalsRepo;

    public AtmNaminalsService(AtmNominalsRepo atmNominalsRepo) {
        this.atmNominalsRepo = atmNominalsRepo;
    }

    //колличество денег в банкомате
    @Bean
    double getTotal(){
        List<AtmNominal> atmNominals =  atmNominalsRepo.findAllByAtmId(1L);
        double total = 0;
        for (int i = 0; i < atmNominals.size(); i++){
            AtmNominal atmNominal = new AtmNominal();
            atmNominal.setAmount(atmNominals.get(i).getAmount());
            atmNominal.setNaminal(atmNominals.get(i).getNaminal());
            total += atmNominal.getAmount() * atmNominal.getNaminal().getNaminals();

        }
        return total;
    }
}
