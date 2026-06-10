package barbershop.demo.models;

import jakarta.persistence.Id;

import java.io.Serializable;

public class AgendamentoModel implements Serializable {

    @Id
    private Integer protocolo;

    private ClienteModel cliente;

    private ProfessionalModel professional;

    private ServicoModel servico;

    
}
