package kg.megacom.atm_service.service;

import java.util.List;

public interface AtmService {
    double checkTotalAmount();


    void addMoneyFromRefill(Long atmId, double amount, List<Double> naminals);
}
