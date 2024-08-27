package ui;

import java.util.List;

import domain.Erro;
import usecases.CadastroVeiculoCtrl;
import usecases.VeiculoRequest;

public class CadastroVeiculoPrt implements Presenter{
    
    private CadastroVeiculoView view;
	private CadastroVeiculoCtrl controller;
	
	public CadastroVeiculoPrt(CadastroVeiculoView view, CadastroVeiculoCtrl controller) 
    {
		super();
		this.view = view;
		this.controller = controller;
	}

    @Override
    public void run(){

        String placa, modelo;
        List<Erro> erros;

        var data = view.readData();

        do 
        {            
            try 
            {
            placa = data.placa();

            } catch (Exception e) {
                placa = null;
            }

            try 
            {
            modelo = data.modelo();

            } catch (Exception e) {
                modelo = null;
            }

            erros = controller.cadastraVeiculo(new VeiculoRequest(
                                                placa,
                                                modelo,
                                                data.anoFabricacao(),
                                                data.valorDiaria(),
                                                data.quilometragem()));
            
            if (erros != null) 
                view.setErros(erros);
            else
                view.setSucesso();
        } while (erros != null);
    }
}
