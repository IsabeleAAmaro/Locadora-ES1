package domain.dao;

import java.time.LocalDateTime;

public record LocacaoListagemDTO(String id,
                                 Long cpfCliente,
                                 String nomeCliente,
                                 String placaVeiculo,
                                 String modeloVeiculo,
                                 LocalDateTime dataHora) {



}
