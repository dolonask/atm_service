package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.services.AtmNominalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/atmNominal")
public class AtmNominalController {

    private final AtmNominalService atmNominalService;

    public AtmNominalController(AtmNominalService atmNominalService) {
        this.atmNominalService = atmNominalService;
    }


}
