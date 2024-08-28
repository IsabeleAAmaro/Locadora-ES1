package ui;

import java.util.Scanner;
import java.util.List;

import domain.Erro;

public class ExclusaoVeiculoView {
    
    public PlacaData readData(){

        var input = new Scanner(System.in);
        String placa;

        System.out.println("\n--------------------");
		System.out.println("Exclusao de Veiculo");
		System.out.println("--------------------");

        do 
        {
            System.out.println("Digite a Placa (XXX9999)");
            placa = input.nextLine().toUpperCase();

        } while (placa.matches("[A-Z]{3}[0-9]{4}"));

        input.close();
        
        return new PlacaData(placa);   
    }

    public void setErros(List<Erro> erros){

        for(var e: erros)
        {
            switch (e) 
            {
                case ERRO_BD           -> System.out.println("Erro ao acessar o BD");
                case PLACA_INEXISTENTE -> System.out.println("Placa Inexistente!");
                default -> throw new IllegalArgumentException("Unexpected value: " + e);
            }
        }
        System.out.println();
    }

    public void setSucesso(){
        System.out.println("Exclusão bem sucedida!");
    }
}
