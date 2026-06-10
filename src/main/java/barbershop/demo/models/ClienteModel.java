package barbershop.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteModel implements Serializable {

    @Id
    @Column(name = "cpf_cliente")
    private String cpf;

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "endereco_cliente")
    private String endereco;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "data_de_nascimento_cliente")
    private Date dataDeNascimento;
}
