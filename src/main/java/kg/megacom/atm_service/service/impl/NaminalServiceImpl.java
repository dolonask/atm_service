package kg.megacom.atm_service.service.impl;

import kg.megacom.atm_service.models.Naminal;
import kg.megacom.atm_service.repository.NaminalRepo;
import kg.megacom.atm_service.service.NaminalService;
import org.springframework.stereotype.Service;

@Service
public class NaminalServiceImpl implements NaminalService {
    private final NaminalRepo naminalRepo;

    public NaminalServiceImpl(NaminalRepo naminalRepo) {
        this.naminalRepo = naminalRepo;
    }

    @Override
    public Long findByNaminals(Double naminal) {
        Naminal naminal1 = naminalRepo.findByNaminals(naminal);
        return naminal1.getId();
    }
}
