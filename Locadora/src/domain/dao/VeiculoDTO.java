package domain.dao;

public record VeiculoDTO(String id,
                         String placa,  
		                 String modelo, 
	                     int anoFabricacao,
	                     double valorDiaria,
	                     int quilometragem) {
}