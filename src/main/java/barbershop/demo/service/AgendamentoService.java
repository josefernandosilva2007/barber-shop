package barbershop.demo.service;

import barbershop.demo.dto.AgendamentoDTO;
import barbershop.demo.models.AgendamentoModel;
import barbershop.demo.models.ClienteModel;
import barbershop.demo.models.ProfessionalModel;
import barbershop.demo.models.ServicoModel;
import barbershop.demo.repository.AgendamentoRepository;
import barbershop.demo.repository.ClienteRepository;
import barbershop.demo.repository.ProfessionalRepository;
import barbershop.demo.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AgendamentoService {


    private final AgendamentoRepository agendamentoRepo;
    private final ClienteRepository clienteRepo;
    private final ServicoRepository servicoRepo;
    private final ProfessionalRepository professionalRepo;

    public AgendamentoService(AgendamentoRepository agendamentoRepo, ClienteRepository clienteRepo, ServicoRepository servicoRepo, ProfessionalRepository professionalRepo) {
        this.agendamentoRepo = agendamentoRepo;
        this.clienteRepo = clienteRepo;
        this.servicoRepo = servicoRepo;
        this.professionalRepo = professionalRepo;
    }

    public AgendamentoModel saveAgendamento(AgendamentoDTO dto){
        ClienteModel cliente = clienteRepo.findById(dto.cpfCliente()).orElse(null);
        ServicoModel servico = servicoRepo.findById(dto.idServico()).orElse(null);
        ProfessionalModel profissional = professionalRepo.findById(dto.cpfProfissional()).orElse(null);

        if (cliente == null) {
            cliente = new ClienteModel();
            cliente.setCpf(dto.cpfCliente());
            cliente.setNome(dto.nomeCliente());
            cliente = clienteRepo.save(cliente);
        }

        if (servico == null || profissional == null) {
            throw new IllegalArgumentException("Profissional ou Serviço não encontrado no banco de dados!");
        }
        AgendamentoModel model = new AgendamentoModel();
        model.setCpfCliente(cliente);
        model.setCpfProfessional(profissional);
        model.setIdServico(servico);

        model.setDataAgendamento(LocalDate.parse(dto.date()));
        model.setHorarioAgendamento(dto.time());

        return agendamentoRepo.save(model);
    }

}
