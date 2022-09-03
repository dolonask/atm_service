package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.*;
import kg.megacom.atm_service.models.enums.OperationStatus;
import kg.megacom.atm_service.models.enums.OperationType;
import kg.megacom.atm_service.repository.AccountRepo;
import kg.megacom.atm_service.repository.AtmRepo;
import kg.megacom.atm_service.repository.OperationRepo;
import kg.megacom.atm_service.requests.BalanceRefillRequest;
import kg.megacom.atm_service.response.BalanceRefillResponse;
import kg.megacom.atm_service.service.AtmService;
import kg.megacom.atm_service.service.BalanceService;
import kg.megacom.atm_service.service.OperationNaminalService;
import kg.megacom.atm_service.service.OperationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {
    private final AccountRepo accountRepo;
    private final AtmRepo atmRepo;
    private final OperationNaminalService operationNaminalService;
    private final OperationRepo operationRepo;
    private final BalanceService balanceService;
    private final AtmService atmService;

    public OperationServiceImpl(AccountRepo accountRepo, AtmRepo atmRepo, OperationNaminalService operationNaminalService, OperationRepo operationRepo, BalanceService balanceService, AtmService atmService) {
        this.accountRepo = accountRepo;
        this.atmRepo = atmRepo;
        this.operationNaminalService = operationNaminalService;
        this.operationRepo = operationRepo;
        this.balanceService = balanceService;
        this.atmService = atmService;
    }

    @Override
    public BalanceRefillResponse refillBalance(BalanceRefillRequest balanceRefillRequest) {


        Optional<Account> account = accountRepo.findById(balanceRefillRequest.getAccountId());
        Optional<Atm> atm = atmRepo.findById(balanceRefillRequest.getAtmId());

        //сохранение операции
        Operation operation = new Operation();
        operation.setOperationType(OperationType.REFILL);
        operation.setOperationDate(new Date());
        operation.setOperationStatus(OperationStatus.SUCCESS);
        operation.setClients(account.get().getClients());
        operation.setAccount(account.get());
        operation.setAmount(balanceRefillRequest.getAmount());
        operation.setAtm(atm.get());
        operationRepo.save(operation);

        //добавить в балансе и вывод инфо

        Balance balance = balanceService.setNewBalance(operation.getAmount(), account.get().getBalance().getId());

        //сохрание в оприрации наминалов
        operationNaminalService.save(balanceRefillRequest.getNaminals(), operation.getId());
        //добавить изменение в атм и атм наминал

        atmService.addMoneyFromRefill(
                balanceRefillRequest.getAtmId(),
                balanceRefillRequest.getAmount(),
                balanceRefillRequest.getNaminals());



        //добавление инфо в респонс

        BalanceRefillResponse balanceRefillResponse = new BalanceRefillResponse();
        balanceRefillResponse.setBalance(balance);
        balanceRefillResponse.setOperationStatus(operation.getOperationStatus().toString());
        return balanceRefillResponse;
    }
}
