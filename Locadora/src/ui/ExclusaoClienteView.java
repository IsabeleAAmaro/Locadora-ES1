package ui;

import domain.Erro;
import java.util.List;
import java.util.Scanner;

public class ExclusaoClienteView {

    public ClienteCPFData readData() {
        var input = new Scanner(System.in);
        String cpf;

        System.out.println("\n--------------------");
        System.out.println("Exclusão de Cliente");
        System.out.println("--------------------");

        while (true) {
            System.out.print("CPF (somente números): ");
            cpf = input.nextLine().trim();

            if (cpf.matches("\\d{11}")) {
                break;
            } else {
                System.out.println("CPF inválido. Por favor, insira um CPF válido com 11 dígitos.");
            }
        }

        Long cpfLong = Long.parseLong(cpf);
        
        return new ClienteCPFData(cpfLong);
    }

    public void setListaErros(List<Erro> erros) {
        for (Erro erro : erros) {
            switch (erro) {
                case CLIENTE_INEXISTENTE -> System.out.println("Erro durante a exclusão: Cliente não encontrado.");
                case ERRO_BD -> System.out.println("Erro durante a exclusão: Erro inesperado. Tente novamente mais tarde ou procure o suporte.");
                default -> throw new IllegalArgumentException("Unexpected value: " + erro);
            }
        }
        System.out.println();
    }

    public void setSucesso() {
        System.out.println("Exclusão bem-sucedida");
    }


}



