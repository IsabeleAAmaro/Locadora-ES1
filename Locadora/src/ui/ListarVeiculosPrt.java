package ui;

import java.util.Collections;
import java.util.Comparator;

import domain.Veiculo;
import usecases.ListarVeiculosCtrl;

public class ListarVeiculosPrt implements Presenter{

	private ListarVeiculosView view;
	private ListarVeiculosCtrl controller;
	
	public ListarVeiculosPrt(ListarVeiculosView view, ListarVeiculosCtrl controller) {
		super();
		this.view = view;
		this.controller = controller;
	}

	@Override
	public void run() {
        
        var resultado = controller.listarVeiculos();
        var ordenacao = view.solicitaOrdenacao();
        
		if (resultado.sucesso())
        {
            if (ordenacao == 'P') 
                Collections.sort(resultado.valor, Comparator.comparing(Veiculo::getPlaca));
            else
                Collections.sort(resultado.valor, Comparator.comparing(Veiculo::getModelo));

			view.mostrarVeiculos(resultado.valor);
		}else
			view.mostrarErro();
	}
}
