package barbershop.demo.dto;

import java.time.LocalDate;

public record AgendamentoDTO(
  String cpfCliente,
  String nomeCliente,
  String enderecoCliente,
  String dataNascimentoCliente,
  String emailCliente,
  String cpfProfissional,
  Integer idServico,
  String date,
  String time
) {}
