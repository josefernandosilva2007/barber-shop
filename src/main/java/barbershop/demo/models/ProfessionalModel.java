package barbershop.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "profissional")
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalModel implements Serializable {

    @Id
    @Column(name = "cpf_profissional")
    private String cpf;
    @Column(name = "nome_profissional")
    private String nome;
    @Column(name = "endereco_profissional")
    private String endereco;

    @Column(name = "email_profissional")
    private String email;

    @Column(name = "data_de_nascimento_profissional")
    private Date dataDeNascimento;

}
