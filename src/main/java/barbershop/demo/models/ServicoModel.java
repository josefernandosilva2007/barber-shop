package barbershop.demo.models;

import jakarta.persistence.Id;

import java.io.Serializable;

public class ServicoModel implements Serializable {
    @Id
    private Integer id;
    private String procedimento;
    private Float preco;
}
