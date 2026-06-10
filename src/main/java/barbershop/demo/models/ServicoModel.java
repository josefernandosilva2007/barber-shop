package barbershop.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "servicos")
public class ServicoModel implements Serializable {
    @Id
    @Column(name = "id_servico")
    private Integer id;
    @Column(name = "nome_procedimento")
    private String procedimento;
    @Column(name = "preco")
    private Float preco;
}
