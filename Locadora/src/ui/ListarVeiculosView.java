package ui;

import java.util.List;
import java.util.regex.Pattern;
import java.util.Scanner;

import domain.Veiculo;

public class ListarVeiculosView {

    public char solicitaOrdenacao(){

        var input = new Scanner(System.in);
        char ordenacao;

        do 
        {
            System.out.println("Ordenar por Placa (P) ou Modelo (M)? ");
            ordenacao = input.nextLine().toUpperCase().charAt(0);

        } while (ordenacao != 'P' && ordenacao != 'M');


        return ordenacao;
    }
    
    public void mostrarVeiculos(List<Veiculo> veiculos) {
        
        if (veiculos.isEmpty())
            System.out.println("\nNão há veículos cadastrados");
        else {
            System.out.println("\n-----------------------------------------------------------");
            System.out.println("Placa      Modelo                          Ano  Diária    Km");
            //                    WWW-9999  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  9999 $999.99   999          
            System.out.println("-----------------------------------------------------------");
            
            for (var v : veiculos) {
                System.out.printf("%s %-30s %d   %.2f    %d\n", 
                        formataPlaca(v.getPlaca()), 
                        v.getModelo(), 
                        v.getAnoFabricacao(),
                        v.getValorDiaria(),
                        v.getQuilometragem());
            }
            System.out.println("-----------------------------------------------------------");
        }
    }
    
    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }

    private String formataPlaca(String placa) {
        return Pattern.compile("([A-Z]{3})(\\d{4})").matcher(placa).replaceAll("$1-$2");
    }
}
