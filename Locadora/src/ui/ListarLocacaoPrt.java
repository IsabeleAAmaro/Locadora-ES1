package ui;

import usecases.ListarLocacaoCtrl;

public class ListarLocacaoPrt implements Presenter{

    private ListarLocacaoView view;
	private ListarLocacaoCtrl controller;
	
	public ListarLocacaoPrt(ListarLocacaoView view, ListarLocacaoCtrl controller) {
		super();
		this.view = view;
		this.controller = controller;
	}

	@Override
	public void run() {
		var resultado = controller.ListarLocacoes();
		
		if (resultado.sucesso())
			view.mostrarLocacoes(resultado.valor);
		else
			view.mostrarErro();
	}
}
