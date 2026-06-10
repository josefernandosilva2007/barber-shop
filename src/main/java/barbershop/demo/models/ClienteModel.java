package barbershop.demo.models;

import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

public class ClienteModel implements Serializable {

    @Id
    private String cpf;

    private String nome;

    private String endereco;

    private String email;

    private Date dataDeNascimento;
}
