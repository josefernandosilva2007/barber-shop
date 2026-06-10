package barbershop.demo.controller;

import barbershop.demo.dto.AgendamentoDTO;
import barbershop.demo.models.AgendamentoModel;
import barbershop.demo.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento")
@CrossOrigin(origins = "*")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoModel> saveAgendamento(@RequestBody AgendamentoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoService.saveAgendamento(dto));
    }
}
