package ui;

import domain.Erro;
import usecases.ClienteCPFRequest;
import usecases.ExclusaoClienteCtrl;

import java.util.List;

public class ExclusaoClientePrt implements Presenter {

    private final ExclusaoClienteView view;
    private final ExclusaoClienteCtrl ctrl;

    public ExclusaoClientePrt(ExclusaoClienteView view, ExclusaoClienteCtrl controller) {
        super();
        this.view = view;
        this.ctrl = controller;
    }

    //TODO: TÃO FAZENDO O PARSELONG AQUI, SERÁ QUE ESSE É O CORRETO??
    //TODO: MUDAR MAIS I GUESS
    @Override
    public void run() {
        Long cpf;
        List<Erro> erros;

        do {
            var data = view.readData();

            //TODO: PORQUE PRECISA DESSE TRY??
            try {
                cpf = data.cpf();
            } catch (Exception ex) {
                cpf = null;
            }

            erros = ctrl.excluirCLiente(new ClienteCPFRequest(cpf));

            if (erros != null)
                view.setListaErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
