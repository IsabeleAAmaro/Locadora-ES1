package usecases;

import java.time.LocalDateTime;

public record LocacaoRequest(Long cpfCliente,
                             String placaVeiculo,
                             LocalDateTime dataHora) {


}
