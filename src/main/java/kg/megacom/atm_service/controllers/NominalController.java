package kg.megacom.atm_service.controllers;

import kg.megacom.atm_service.models.dto.NominalDto;
import kg.megacom.atm_service.models.entities.Nominal;
import kg.megacom.atm_service.services.NominalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/nominal")
public class NominalController {
    private final NominalService nominalService;

    public NominalController(NominalService nominalService) {
        this.nominalService = nominalService;
    }

    @PostMapping("/createNewNominal")
    public NominalDto createNominal (@RequestBody NominalDto nominalDto) {return nominalService.createNewNominal(nominalDto);}

    @GetMapping("/findNominal")
    public Nominal findById (@RequestParam Long id) {return nominalService.findById(id);}
}
