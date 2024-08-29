package ui;

import java.util.List;
import java.util.Scanner;

import domain.Erro;

public class CadastroVeiculoView {
    
    public VeiculoData readData() {
        var input = new Scanner(System.in);
		String placa, modelo;
        int anoFabricacao, quilometragem;
        double valorDiaria;
		
		System.out.println("\n--------------------");
		System.out.println("Cadastro de Veiculos");
		System.out.println("--------------------");
		
		System.out.print("Placa: ");
		placa = input.nextLine().toUpperCase();
		
		System.out.print("Nome: ");
		modelo = input.nextLine();
		
		System.out.print("Ano Fabricação: ");
		anoFabricacao = input.nextInt();
		
		System.out.print("Quilometragem (KM): ");
		quilometragem = input.nextInt();
		
		System.out.print("Diaria (R$): ");
		valorDiaria = input.nextDouble();

		return new VeiculoData( placa,
                                modelo,
                                anoFabricacao,
                                valorDiaria,
                                quilometragem
				       		   );
    }

    public void setErros (List<Erro> erros) {
        System.out.println("\nErro no cadastramento:");
        for (var erro : erros) {
            switch (erro) {
                case PLACA_INVALIDA          -> System.out.println("Placa inválida!");
                case PLACA_REPETIDA          -> System.out.println("Placa Repetida!");
                case MODELO_INVALIDO         -> System.out.println("Modelo inválido!");
                case DIARIA_VALOR_INVALIDO   -> System.out.println("Valor da diária inválido!");
                case ANO_FABRICACAO_INVALIDO -> System.out.println("Ano da Fabricação inválido!");
                case QUILOMETRAGEM_INVALIDA  -> System.out.println("Quilometragem inválida!");
                default -> throw new IllegalArgumentException("Unexpected value: " + erro);
            }
        }
        System.out.println();
    } 

    public void setSucesso(){
        System.out.println("Cadastro realizado com Sucesso!");
    }
}
