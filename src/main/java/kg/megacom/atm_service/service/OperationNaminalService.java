package kg.megacom.atm_service.service;

import kg.megacom.atm_service.models.OperationNaminal;

import java.util.List;

public interface OperationNaminalService {
    void save(List<Double> naminals, Long operationId);
}
