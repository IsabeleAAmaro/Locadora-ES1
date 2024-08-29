package ui;

import usecases.ListarClientesCtrl;

public class ListarClientesPrt implements Presenter {

	private final ListarClientesView view;
	private final ListarClientesCtrl controller;
	
	public ListarClientesPrt(ListarClientesView view, ListarClientesCtrl controller) {
		super();
		this.view = view;
		this.controller = controller;
	}

	@Override
	public void run() {
		var resultado = controller.recuperarTodosClientes();
		
		if (resultado.sucesso())
			view.mostrarClientes(resultado.valor);
		else
			view.mostrarErro();
	}
}





