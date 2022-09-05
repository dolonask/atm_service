package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.dto.AtmDto;
import kg.megacom.atm_service.models.entities.Atm;
import kg.megacom.atm_service.services.AtmService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/atm")
public class AtmController {

    private final AtmService atmService;

    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/createAtm")
    public Atm createAtm (@RequestBody Atm atm) {return atmService.createAmt(atm);}

    @GetMapping("/findAtm")
    public Atm findById (@RequestParam Long id) {return atmService.findById(id);}
}
