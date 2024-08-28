package ui;

import java.util.List;

import domain.Erro;
import usecases.LocarVeiculoCtrl;
import usecases.LocacaoRequest;

public class LocarVeiculoPrt implements Presenter{
    
    private LocarVeiculoView view;
	private LocarVeiculoCtrl controller;
	
	public LocarVeiculoPrt(LocarVeiculoView view, LocarVeiculoCtrl controller) 
    {
		super();
		this.view = view;
		this.controller = controller;
	}

    @Override
    public void run(){

        Long cpf;
        List<Erro> erros;

        do 
        {            
            var data = view.readData();

            try 
            {
				cpf = Long.parseLong(data.cpfCliente());
			}catch(Exception ex) 
            {
				cpf = null;
			}

            erros = controller.locarVeiculo(new LocacaoRequest( cpf,
                                                                data.placaVeiculo(),
                                                                data.dataHora()));
            
            if (!erros.isEmpty()) 
                view.setErros(erros);
            else
                view.setSucesso();

        } while (!erros.isEmpty());
    }
}
