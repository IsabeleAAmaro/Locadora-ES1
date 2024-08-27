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
		String ordenacao = view.readData();

		switch (ordenacao) {
			case "C":
				var resultadoCPF = controller.recuperarTodosClientesPorCPF();
				if (resultadoCPF.sucesso())
					view.mostrarClientes(resultadoCPF.valor);
				else
					view.mostrarErro();
				break;

			case "N":
				var resultadoNome = controller.recuperarTodosClientesPorNome();
				if (resultadoNome.sucesso())
					view.mostrarClientes(resultadoNome.valor);
				else
					view.mostrarErro();
				break;

			default:
				var resultadoTodos = controller.recuperarTodosClientes();
				if (resultadoTodos.sucesso())
					view.mostrarClientes(resultadoTodos.valor);
				else
					view.mostrarErro();
				break;
		}

		/*
				if (resultado.sucesso())
			view.mostrarClientes(resultado.valor);
		else
			view.mostrarErro();
		 */

	}
}





