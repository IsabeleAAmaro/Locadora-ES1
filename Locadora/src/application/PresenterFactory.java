package application;

import ui.MenuPresenter;
import ui.MenuView;
import ui.Presenter;

//Imports Cliente
import domain.ClienteRepository;
import persistence.ClienteDAO;
import ui.CadastroClientePrt;
import ui.CadastroClienteView;
import ui.ExclusaoClientePrt;
import ui.ExclusaoClienteView;
import ui.ListarClientesPrt;
import ui.ListarClientesView;

import usecases.CadastroClienteCtrl;
import usecases.ExclusaoClienteCtrl;
import usecases.ListarClientesCtrl;

//Import Veiculos
import domain.VeiculoRepository;
import persistence.VeiculoDAO;
import ui.CadastroVeiculoPrt;
import ui.CadastroVeiculoView;
import ui.ExclusaoVeiculoPrt;
import ui.ExclusaoVeiculoView;
import ui.ListarVeiculosPrt;
import ui.ListarVeiculosView;

import usecases.CadastroVeiculoCtrl;
import usecases.ExclusaoVeiculoCtrl;
import usecases.ListarVeiculosCtrl;

//Import Locacao 

import domain.LocacaoRepository;
import persistence.LocacaoDAO;
import ui.LocarVeiculoPrt;
import ui.LocarVeiculoView;
import ui.ListarLocacaoPrt;
import ui.ListarLocacaoView;

import usecases.LocarVeiculoCtrl;
import usecases.ListarLocacaoCtrl;


/**
 * Classe responsável por criar os presenters e sua estrutura
 */
public class PresenterFactory {

	/**
	 * Tipo do presenter
	 */
	public enum Type { 	MENU, 
						CADASTRAR_CLIENTE, 
						EXCLUIR_CLIENTE, 
						LISTAR_CLIENTE,
						CADASTRAR_VEICULO,
						EXCLUIR_VEICULO,
				     	LISTAR_VEICULO,
						LOCAR_VEICULO,
						LISTAR_LOCACAO };
	
    /**
     * Cria um presenter de acordo com o tipo solicitado
     * 
     * @param type Tipo do presenter
     * @return Presenter
     */
	public static Presenter get(Type type) {
		switch(type) {
			case MENU -> {
				var view = new MenuView(); 
				
				return new MenuPresenter(view);
			}
		
			case CADASTRAR_CLIENTE -> {
				var repository = new ClienteRepository(new ClienteDAO());
				var view = new CadastroClienteView();
				var controller = new CadastroClienteCtrl(repository);

				return new CadastroClientePrt(view, controller);
			}
		
			case EXCLUIR_CLIENTE -> {
				var repository = new ClienteRepository(new ClienteDAO());
				var view = new ExclusaoClienteView();
				var controller = new ExclusaoClienteCtrl(repository);

				return new ExclusaoClientePrt(view, controller);
			}
		
			case LISTAR_CLIENTE -> {
				var repository = new ClienteRepository(new ClienteDAO());
				var view = new ListarClientesView();
				var controller = new ListarClientesCtrl(repository);

				return new ListarClientesPrt(view, controller);
			}

			case CADASTRAR_VEICULO -> {
				var repository = new VeiculoRepository(new VeiculoDAO());
				var view = new CadastroVeiculoView();
				var controller = new CadastroVeiculoCtrl(repository);

				return new CadastroVeiculoPrt(view, controller);

			}
		
			case EXCLUIR_VEICULO -> {
				var repository = new VeiculoRepository(new VeiculoDAO());
				var view = new ExclusaoVeiculoView();
				var controller = new ExclusaoVeiculoCtrl(repository);

				return new ExclusaoVeiculoPrt(view, controller);
			}
		
			case LISTAR_VEICULO -> {
				var repository = new VeiculoRepository(new VeiculoDAO());
				var view = new ListarVeiculosView();
				var controller = new ListarVeiculosCtrl(repository);

				return new ListarVeiculosPrt(view, controller);
			}

			case LOCAR_VEICULO -> {
				var repository = new LocacaoRepository(new LocacaoDAO());

				var repoCliente = new ClienteRepository(new ClienteDAO());
				var repoVeiculo = new VeiculoRepository(new VeiculoDAO());

				var view = new LocarVeiculoView();

				var controller = new LocarVeiculoCtrl(repository, repoVeiculo, repoCliente);

				return new LocarVeiculoPrt(view, controller);
			}
		
			case LISTAR_LOCACAO -> {
				var repository = new LocacaoRepository(new LocacaoDAO());
				var view = new ListarLocacaoView();
				var controller = new ListarLocacaoCtrl(repository);

				return new ListarLocacaoPrt(view, controller);
			}
		};
		return null;
	}
}
