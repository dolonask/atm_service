package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.Naminal;

import java.util.List;

public interface AtmService {
    double checkTotalAmount();


    void addMoneyFromRefill(Long atmId, double amount, List<Double> naminals);

    void checkAvailableAmount(Long atmId, double amount);

    List<Double> withdrawMoney(Long atmId, double amount);
}
