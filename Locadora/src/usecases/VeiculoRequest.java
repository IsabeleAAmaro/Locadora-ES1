package usecases;

public record VeiculoRequest(String placa,
                          String modelo,
                          int anoFabricacao,
                          double valorDiaria,
                          int quilometragem) {
}
