package usecases;

import domain.Erro;
import domain.Locacao;
import domain.LocacaoRepository;
import domain.Resultado;

import java.sql.SQLException;
import java.util.List;

public class ListarLocacaoCtrl {
    private final LocacaoRepository repo;

    //TODO: Colocar tabelas veiculo e locacao no locadora.sql

    public ListarLocacaoCtrl(LocacaoRepository repository) {
        super();
        this.repo = repository;
    }

    //TODO: Criar aquele comentário gigante em cimakk

    public Resultado<List<Locacao>> ListarLocacoes() {
        try {
            var locacoes = repo.findAll();
            return Resultado.ok(locacoes);

        } catch (SQLException e) {
            return Resultado.erro(List.of(Erro.ERRO_BD));
        }
    }
}
