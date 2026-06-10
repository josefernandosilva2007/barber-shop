package barbershop.demo.models;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class AgendamentoModel implements Serializable {

    @Id
    private Integer protocolo;

    @ManyToOne
    private ClienteModel cpfCliente;

    @ManyToOne
    private ProfessionalModel cpfProfessional;

    private ServicoModel idServico;

    
}
