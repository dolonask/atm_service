package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.OperationNaminal;
import kg.megacom.atm_service.repository.NaminalRepo;
import kg.megacom.atm_service.repository.OperationNaminalRepo;
import kg.megacom.atm_service.repository.OperationRepo;
import kg.megacom.atm_service.service.OperationNaminalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperationNaminalServiceImpl implements OperationNaminalService {
    private final OperationNaminalRepo operationNaminalRepo;
    private final OperationRepo operationRepo;
    private final NaminalRepo naminalRepo;

    public OperationNaminalServiceImpl(OperationNaminalRepo operationNaminalRepo, OperationRepo operationRepo, NaminalRepo naminalRepo) {
        this.operationNaminalRepo = operationNaminalRepo;
        this.operationRepo = operationRepo;
        this.naminalRepo = naminalRepo;
    }

    //сохранение и генерация операции наминалов
    @Override
    public void save(List<Double> naminals, Long operationId) {
        for (int i = 0; i < naminals.size(); i++) {
            OperationNaminal operationNaminal = new OperationNaminal();
            operationNaminal.setOperation(operationRepo.findById(operationId).orElseThrow());
            operationNaminal.setNaminal(naminalRepo.findByNaminals(naminals.get(i)));
            operationNaminal.setAmount(naminals.get(i));
            operationNaminalRepo.save(operationNaminal);
        }
    }
}
