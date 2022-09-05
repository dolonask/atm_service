package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.BalanceRepo;
import kg.megacom.atm_service.mappers.BalanceMapper;
import kg.megacom.atm_service.models.dto.BalanceDto;
import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.services.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepo balanceRepo;
    private final BalanceMapper balanceMapper;

    public BalanceServiceImpl(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
        this.balanceMapper = BalanceMapper.INSATANCE;
    }

    @Override
    public BalanceDto create(BalanceDto balanceDto) {
        Balance balance = balanceMapper.toEntity(balanceDto);
        balance = balanceRepo.save(balance);

        return balanceMapper.toDto(balance);
    }

    @Override
    public Balance update(Long id, double amount,double blockedAmount) {

        return balanceRepo.update( id,amount,blockedAmount);
    }

    @Override
    public Balance findById(Long id) {
        return balanceRepo.findById(id).orElseThrow(()-> new RuntimeException("Указанный баланс не найден"));
    }
}
