package usecases;

import java.sql.SQLException;
import java.util.List;

import domain.VeiculoBuilder;
import domain.VeiculoRepository;
import domain.Erro;

public class CadastroVeiculoCtrl {
    
    private final VeiculoRepository repo;

    public CadastroVeiculoCtrl (VeiculoRepository repo) {
        super();
        this.repo = repo;
    }

    public List<Erro> cadastraVeiculo (VeiculoRequest request){

        try {
            var result = new VeiculoBuilder()
                             .withPlaca(request.placa())
                             .withModelo(request.modelo())
                             .withAnoFabr(request.anoFabricacao())
                             .withDiaria(request.valorDiaria())
                             .withKM(request.quilometragem())
                             .build();
            
            if (result.sucesso()) {
                var veiculo = result.valor;   

                var outroVeiculo = repo.findByPlaca(veiculo.getPlaca());

                if (outroVeiculo != null) 
                    return List.of(Erro.PLACA_REPETIDA);
                
                repo.add(veiculo);
                return null;
            } else
                return result.erros;
                                 
        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }
}
