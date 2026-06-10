package barbershop.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "agendamento")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AgendamentoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer protocolo;


    @ManyToOne
    @JoinColumn(name = "cpf_cliente")
    private ClienteModel cpfCliente;

    @ManyToOne
    @JoinColumn(name = "cpf_profissional")
    private ProfessionalModel cpfProfessional;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private ServicoModel idServico;

    private LocalDate dataAgendamento;

    private String horarioAgendamento;


}
