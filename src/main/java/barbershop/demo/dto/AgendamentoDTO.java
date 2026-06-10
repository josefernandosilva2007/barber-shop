package barbershop.demo.dto;

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
