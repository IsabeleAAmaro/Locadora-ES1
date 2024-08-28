package usecases;

import domain.Erro;
import domain.LocacaoBuilder;
import domain.LocacaoRepository;

import java.sql.SQLException;
import java.util.List;

public class LocarVeiculoCtrl {
    private final LocacaoRepository repo;

    public LocarVeiculoCtrl(LocacaoRepository repository) {
        super();
        this.repo = repository;
    }

    public List<Erro> locarVeiculo(LocacaoRequest request) {
        try {
            var resultado = new LocacaoBuilder()
                    .withCPFCliente(request.cpfCliente())
                    .withPlacaVeiculo(request.placaVeiculo())
                    .withDataHora(request.dataHora())
                    .build(false);

            if (resultado.sucesso()) {
                var locacao = resultado.valor;
                var outroCliente = repo.findByCPF(locacao.getCpfCliente().valor);
                var outroVeiculo = repo.findByPlaca(locacao.getPlacaVeiculo());

                if (outroCliente != null || outroVeiculo != null)
                    return List.of(Erro.VEICULO_JA_ALOCADO);

                if (locacao.getCpfCliente() == null)
                    return List.of(Erro.CLIENTE_INEXISTENTE);

                //TODO: Implementar verificacao aqui depois de add o erro lá
                /*
                if (locacao.getPlacaVeiculo() == null){
                    return List.of(Erro.VEICULO_INEXISTENTE);
                }
                 */

                repo.add(locacao);
                return null;
            } else {
                return resultado.erros;
            }

        } catch (SQLException e) {
            return List.of(Erro.ERRO_BD);
        }
    }
}
