package usecases;

import domain.ClienteRepository;
import domain.Erro;
import domain.LocacaoBuilder;
import domain.LocacaoRepository;
import domain.VeiculoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocarVeiculoCtrl {
    private final LocacaoRepository repo;
    private final VeiculoRepository repoVeiculo;
    private final ClienteRepository repoCliente;

    public LocarVeiculoCtrl(LocacaoRepository repository, VeiculoRepository repoVeiculo, ClienteRepository repoCliente) {
        super();
        this.repo = repository;
        this.repoVeiculo = repoVeiculo;
        this.repoCliente = repoCliente;
    }

    public List<Erro> locarVeiculo(LocacaoRequest request) {
       
        try 
        {
            var resultado = new  LocacaoBuilder()
                                .withCPFCliente(request.cpfCliente())
                                .withPlacaVeiculo(request.placaVeiculo())
                                .withDataHora(request.dataHora())
                                .build(false);

            if (resultado.sucesso()) 
            {  
                var locacao = resultado.valor;

                List<Erro> erros = new ArrayList<>(); 

                //Verifica se a placa já foi cadastrada
                var outroVeiculo = repo.findByPlaca(locacao.getPlacaVeiculo());

                //Verifica se o cliente existe no BD
                var clienteCadastrado = repoCliente.findByCPF(locacao.getCpfCliente().valor);

                //Verifica se o veiculo existe no BD
                var veiculoCadastrado = repoVeiculo.findByPlaca(locacao.getPlacaVeiculo());

                if (outroVeiculo != null)
                    erros.add(Erro.VEICULO_JA_ALOCADO);

                if (clienteCadastrado == null)
                    erros.add(Erro.CLIENTE_INEXISTENTE);

                if (veiculoCadastrado != null)
                    erros.add(Erro.PLACA_INEXISTENTE);
                 
                if (erros.isEmpty())                 
                    repo.add(locacao);

                return erros;

            } else 
                return resultado.erros;

        } catch (SQLException e) 
        {
            return List.of(Erro.ERRO_BD);
        }
    }
}
