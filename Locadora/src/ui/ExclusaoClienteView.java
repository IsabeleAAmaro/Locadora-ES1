package ui;

import domain.Erro;
import java.util.List;

public class ExclusaoClienteView {

    public void setErro(List<Erro> erros) {
        for (Erro erro : erros) {
            switch (erro) {
                case CLIENTE_INEXISTENTE -> System.out.println("Erro durante a exclusão: Cliente não encontrado.");
                case ERRO_BD -> System.out.println("Erro durante a exclusão: Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
            }
        }
        System.out.println();
    }

    public void setSucesso() {
        System.out.println("Exclusão bem-sucedida");
    }


}



