package barbershop.demo.service;

import barbershop.demo.dto.AgendamentoDTO;
import barbershop.demo.models.AgendamentoModel;
import barbershop.demo.repository.AgendamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepo;

    public AgendamentoModel saveAgendamento(AgendamentoDTO dto){
        AgendamentoModel model = new AgendamentoModel();
        BeanUtils.copyProperties(dto, model);
        return agendamentoRepo.save(model);
    }

}
