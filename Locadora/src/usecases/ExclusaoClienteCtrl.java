package usecases;

import domain.ClienteBuilder;
import domain.ClienteRepository;
import domain.Erro;

import java.sql.SQLException;
import java.util.List;

public class ExclusaoClienteCtrl {

    private final ClienteRepository repo;

    public ExclusaoClienteCtrl(ClienteRepository repo) {
        this.repo = repo;
    }

    //TODO: ?

    public List<Erro> excluirCLiente(ClienteCPFRequest cpfRequest){
        try{
            var resultado = new ClienteBuilder()
                    .withCPF(cpfRequest.cpf())
                    .build();

            if (resultado.sucesso()) {
                var cliente = resultado.valor;

                if (cliente.getId() == null)
                    return List.of(Erro.CLIENTE_INEXISTENTE);

                repo.remove(cliente.getCpf().valor);
                return null;
            } else {
                return resultado.erros;
            }

        } catch (SQLException e){
            return List.of(Erro.ERRO_BD);
        }

    }
}
