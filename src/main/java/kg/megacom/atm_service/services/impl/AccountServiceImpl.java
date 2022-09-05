package kg.megacom.atm_service.services.impl;

import kg.megacom.atm_service.dao.AccountRepo;
import kg.megacom.atm_service.models.entities.Account;
import kg.megacom.atm_service.models.entities.Balance;
import kg.megacom.atm_service.models.entities.Client;
import kg.megacom.atm_service.models.enums.StatusOfClient;
import kg.megacom.atm_service.models.requests.RequestOne;
import kg.megacom.atm_service.models.requests.RequestWithdraw;
import kg.megacom.atm_service.models.responses.ResponseOne;
import kg.megacom.atm_service.models.responses.ResponseWithdraw;
import kg.megacom.atm_service.services.AccountService;
import kg.megacom.atm_service.services.AtmService;
import kg.megacom.atm_service.services.BalanceService;
import kg.megacom.atm_service.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final AtmService atmService;
    private final BalanceService balanceService;
    private final ClientService clientService;


    public AccountServiceImpl(AccountRepo accountRepo, AtmService atmService, BalanceService balanceService, ClientService clientService) {
        this.accountRepo = accountRepo;
        this.atmService = atmService;
        this.balanceService = balanceService;
        this.clientService = clientService;
    }

    @Override
    public Account save(Account account){
        return accountRepo.save(account);
    }

    @Override
    public ResponseOne loginIntoAcc(RequestOne requestOne) {
        Account account = findByNumber(requestOne.getAccountNumber());
        ResponseOne responseOne = new ResponseOne();
        responseOne.setAvailableAmount(account.getBalance()
                .getAmount()-account.getBalance().getBlockedAmount());
        responseOne.setBlockedAmount(account.getBalance().getBlockedAmount());

        return responseOne;
    }

    @Override
    public Account findByNumber(String accNumber){
        return accountRepo.findByAccountNumber(accNumber);
    }

    @Override
    public ResponseWithdraw withdrawMoney(RequestWithdraw requestWithdraw) {
        Account account = findByNumber(requestWithdraw.getAccountNumber());
        Balance balance = account.getBalance();
        Client client = account.getClient();

        int limit = account.getClient().getLimit();

        if(client.getClientStatus().getStatusOfClient().equals(StatusOfClient.BLOCKED)) {
            throw new RuntimeException("Клиент заблокирован");
        }
        if(client.getClientStatus().getStatusOfClient().equals(StatusOfClient.ARRESTED)) {
            throw new RuntimeException("Счета клиента арестованы");
        }

        if(balance.getAmount()< requestWithdraw.getMoney()){
            throw new RuntimeException("Денег на счету не достаточно, выберите другую сумму");
        }else if(balance.getAmount() >= requestWithdraw.getMoney()){
            if(requestWithdraw.getMoney() >
                    atmService.findMoneyByAtm((long) requestWithdraw.getAtmNumber()).getAmount()){
                throw new RuntimeException("В банкомате недостаточно средств, выберите другую сумму");
            } else if(requestWithdraw.getMoney() < limit){
                ResponseWithdraw responseWithdraw = new ResponseWithdraw();
                responseWithdraw.setNominal(atmService.findMoneyByAtm((long) requestWithdraw.getAtmNumber()).getAmount());

                balance.setAmount(balance.getAmount()- requestWithdraw.getMoney());
                balance.setBlockedAmount(balance.getBlockedAmount()+ requestWithdraw.getMoney());
                limit = limit- requestWithdraw.getMoney();
                client.setLimit(limit);

                clientService.save(client);
                balanceService.save(balance);
                return responseWithdraw;
            }else
                throw new RuntimeException("Вы превысили месячный лимит обналичиваний с банкомата. Обратитесь в филиал банка");
        }return null;
    }
}
