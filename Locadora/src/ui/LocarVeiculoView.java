package ui;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;

import domain.Erro;

public class LocarVeiculoView {

    public LocacaoData readData()
    {
        var input = new Scanner(System.in);
        String placa, cpf;

        System.out.println("\n--------------------");
		System.out.println("Locação de Veículos");
		System.out.println("--------------------");

        System.out.println("CPF do cliente: ");
        cpf = input.nextLine();

        System.out.println("Placa do veículo: ");
        placa = input.nextLine();

        LocalDateTime data = LocalDateTime.now();


        return new LocacaoData(cpf, placa, data);
    }

    public void setErros(List<Erro> erros){

        for (var erro : erros) 
        {
            switch (erro)
            {
                case CLIENTE_INEXISTENTE -> System.out.println("Cliente não cadastrado!");
                case CPF_INVALIDO        -> System.out.println("CPF inválido!");
                case DATA_INVALIDA       -> System.out.println("Data inválida!");
                case PLACA_INVALIDA      -> System.out.println("Placa inválida!");
                case PLACA_INEXISTENTE   -> System.out.println("Placa não cadastrada!");
                case VEICULO_JA_ALOCADO  -> System.out.println("Veículo já alocado!");
                default -> throw new IllegalArgumentException("Unexpected value: " + erro);
            }
        }
    }

    public void setSucesso(){
        System.out.println("Locação bem Sucedida");
    }

}
