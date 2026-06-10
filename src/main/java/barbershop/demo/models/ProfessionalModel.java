package barbershop.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalModel implements Serializable {

    @Id
    private String cpf;

    private String nome;
    private String endereco;
    private String email;
    private Date dataDeNascimento;

}
