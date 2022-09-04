package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.requests.RefillRequest;
import kg.megacom.atm_service.requests.TransferRequest;
import kg.megacom.atm_service.requests.WithdrawalRequest;
import kg.megacom.atm_service.response.RefillResponse;
import kg.megacom.atm_service.response.TransferResponse;
import kg.megacom.atm_service.service.OperationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    //пополнение баланса
    @PostMapping("/refill-balance")
    RefillResponse refillBalance(@RequestBody RefillRequest refillRequest){
        return operationService.refillBalance(refillRequest);
    }
    //снятие наличных
    @PostMapping("/withdraw")
    List<Double> cashWithdraw(@RequestBody WithdrawalRequest withdrawalRequest){
        return operationService.cashWithdraw(withdrawalRequest);
    }
    @PostMapping("/transfer")
    TransferResponse transfer(@RequestBody TransferRequest transferRequest){
        return operationService.transfer(transferRequest);
    }
}
