package ui;

import domain.Erro;
import usecases.PlacaRequest;
import usecases.ExclusaoVeiculoCtrl;

import java.util.List;

public class ExclusaoVeiculoPrt implements Presenter {

    private final ExclusaoVeiculoView view;
    private final ExclusaoVeiculoCtrl ctrl;

    public ExclusaoVeiculoPrt(ExclusaoVeiculoView view, ExclusaoVeiculoCtrl controller) {
        super();
        this.view = view;
        this.ctrl = controller;
    }

    @Override
    public void run()
    {
        List<Erro> erros;

        do 
        {
            var data = view.readData();

            erros = ctrl.excluirVeiculo(new PlacaRequest(data.placa()));

            if (erros != null)
                view.setErros(erros);
            else
                view.setSucesso();

        } while (erros != null);
    }
}