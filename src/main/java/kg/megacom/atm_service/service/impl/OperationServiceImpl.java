package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.*;
import kg.megacom.atm_service.models.enums.OperationStatus;
import kg.megacom.atm_service.models.enums.OperationType;
import kg.megacom.atm_service.repository.AccountRepo;
import kg.megacom.atm_service.repository.AtmRepo;
import kg.megacom.atm_service.repository.OperationRepo;
import kg.megacom.atm_service.requests.RefillRequest;
import kg.megacom.atm_service.requests.TransferRequest;
import kg.megacom.atm_service.requests.WithdrawalRequest;
import kg.megacom.atm_service.response.RefillResponse;
import kg.megacom.atm_service.response.TransferResponse;
import kg.megacom.atm_service.service.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {
    private final AccountRepo accountRepo;
    private final AtmRepo atmRepo;
    private final OperationNaminalService operationNaminalService;
    private final OperationRepo operationRepo;
    private final BalanceService balanceService;
    private final AtmService atmService;
    private final AccountService accountService;

    public OperationServiceImpl(AccountRepo accountRepo, AtmRepo atmRepo, OperationNaminalService operationNaminalService, OperationRepo operationRepo, BalanceService balanceService, AtmService atmService, AccountService accountService) {
        this.accountRepo = accountRepo;
        this.atmRepo = atmRepo;
        this.operationNaminalService = operationNaminalService;
        this.operationRepo = operationRepo;
        this.balanceService = balanceService;
        this.atmService = atmService;
        this.accountService = accountService;
    }

    @Override
    public RefillResponse refillBalance(RefillRequest refillRequest) {


        Optional<Account> account = accountRepo.findById(refillRequest.getAccountId());
        Optional<Atm> atm = atmRepo.findById(refillRequest.getAtmId());

        //сохранение операции
        Operation operation = new Operation();
        operation.setOperationType(OperationType.REFILL);
        operation.setOperationDate(new Date());
        operation.setOperationStatus(OperationStatus.SUCCESS);
        operation.setClients(account.get().getClients());
        operation.setAccount(account.get());
        operation.setAmount(refillRequest.getAmount());
        operation.setAtm(atm.get());
        operationRepo.save(operation);

        //добавить в балансе и вывод инфо

        Balance balance = balanceService.setNewBalance(operation.getAmount(), account.get().getBalance().getId());

        //сохрание в оприрации наминалов
        operationNaminalService.save(refillRequest.getNaminals(), operation.getId());
        //добавить изменение в атм и атм наминал

        atmService.addMoneyFromRefill(
                refillRequest.getAtmId(),
                refillRequest.getAmount(),
                refillRequest.getNaminals());



        //добавление инфо в респонс

        RefillResponse balanceRefillResponse = new RefillResponse();
        balanceRefillResponse.setBalance(balance);
        balanceRefillResponse.setOperationStatus(operation.getOperationStatus().toString());
        return balanceRefillResponse;
    }

    @Override
    public List<Double> cashWithdraw(WithdrawalRequest withdrawalRequest) {
        Account account = accountRepo.findById(withdrawalRequest.getAccountId()).orElseThrow();
        Atm atm = atmRepo.findById(withdrawalRequest.getAtmId()).orElseThrow();

        //проверка счета клиента на наличие денег и лимита на снятие
        //блокировка суммы
        accountService.checkAvailableMoney(withdrawalRequest.getAccountId(), withdrawalRequest.getAmount());
        // проверка есть ли деньги в банкомате
        atmService.checkAvailableAmount(withdrawalRequest.getAtmId(), withdrawalRequest.getAmount());
        // выдоча денег из банкомата
        List<Double> naminals = atmService.withdrawMoney(withdrawalRequest.getAtmId(), withdrawalRequest.getAmount());
        //прочиска блокированной суммы
        accountService.removeBlockedAmount(withdrawalRequest.getAccountId(), withdrawalRequest.getAmount());


       //саздание операции
        Operation operationWithdraw = new Operation();
        operationWithdraw.setOperationType(OperationType.WITHDRAW);
        operationWithdraw.setOperationDate(new Date());
        operationWithdraw.setOperationStatus(OperationStatus.SUCCESS);
        operationWithdraw.setClients(account.getClients());
        operationWithdraw.setAccount(account);
        operationWithdraw.setAmount(withdrawalRequest.getAmount());
        operationWithdraw.setAtm(atm);
        operationRepo.save(operationWithdraw);
        return naminals;
    }

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {

        //проверка счета клиента на наличие денег и лимита на снятие
        //блокировка суммы
        accountService.checkAvailableMoney(transferRequest.getFromAccount(), transferRequest.getAmount());
        //перевод денег
        accountService.moneyTransfer(transferRequest);

        //прочиска блокированной суммы
        accountService.removeBlockedAmount(transferRequest.getFromAccount(), transferRequest.getAmount());

        Account fromAccount = accountRepo.findById(transferRequest.getFromAccount()).orElseThrow();
        Account toAccount = accountRepo.findById(transferRequest.getToAccount()).orElseThrow();
        //саздание операции
        Operation operationTransfer = new Operation();
        operationTransfer.setOperationType(OperationType.WITHDRAW);
        operationTransfer.setOperationDate(new Date());
        operationTransfer.setOperationStatus(OperationStatus.SUCCESS);
        operationTransfer.setClients(fromAccount.getClients());
        operationTransfer.setAccount(fromAccount);
        operationTransfer.setAmount(transferRequest.getAmount());
        operationRepo.save(operationTransfer);

        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setFromAccount(fromAccount);
        transferResponse.setToAccount(toAccount);
        return transferResponse;
    }
}
