package ui;

import domain.Erro;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class LocarVeiculoView {

    public LocacaoData readData() {
        var input = new Scanner(System.in);
        String cpf, placa;

        System.out.println("Locação de Veículos");

        System.out.print("CPF (Somente números): ");
        cpf = input.nextLine();

        System.out.print("Placa do veículo: ");
        placa = input.nextLine();

        return new LocacaoData(cpf, placa, LocalDateTime.now());
    }

    //TODO: Adicionar erro de veiculo inexistente
    public void setErros(List<Erro> erros) {
        for (var erro : erros) {
            switch (erro) {
                case CLIENTE_INEXISTENTE -> System.out.println("Erro na locação - CPF inválido!");
                case VEICULO_JA_ALOCADO -> System.out.println("Erro na locação - Veículo já alocado!");
                case LOCACAO_INEXISTENTE -> System.out.println("Erro na locação - Locação inválida!");
                case ERRO_BD -> System.out.println("Erro inesperado na locação. Tente novamente mais tarde ou procure o suporte.");
                default -> System.out.println("Erro inesperado na locação. Tente novamente: " + erro.toString());
            }
        }
    }

    public void setSucesso() {
        System.out.println("Locação bem-sucedida");
    }
}
