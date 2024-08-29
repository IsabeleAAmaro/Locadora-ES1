package usecases;

import java.util.List;
import java.sql.SQLException;

import domain.VeiculoRepository;
import domain.Erro;

public class ExclusaoVeiculoCtrl {
    
    private final VeiculoRepository repo;

    public ExclusaoVeiculoCtrl(VeiculoRepository repo) {
        super();
        this.repo = repo;
    }

    public List<Erro> excluirVeiculo(PlacaRequest request) {
        try {
            var result = repo.findByPlaca(request.placa());
            
            if (result == null) 
                return List.of(Erro.PLACA_INEXISTENTE);
            
            repo.remove(result);
            return null;

        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }
}
