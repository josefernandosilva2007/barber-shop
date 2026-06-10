package barbershop.demo.dto;

public record AgendamentoDTO(
  String cpfCliente,
  String cpfProfissional,
  Integer idServico
) {}
