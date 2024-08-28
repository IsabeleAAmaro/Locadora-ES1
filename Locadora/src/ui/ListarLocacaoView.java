package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import domain.Locacao;

public class ListarLocacaoView {

    public void mostrarLocacoes(List<Locacao> locacoes) {
        
        if (locacoes.isEmpty()) 
            System.out.println("\nNão há locações cadastradas.");
        else 
        {
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("CPF            Nome                           Placa    Modelo                          Data/hora");
            //                  999.999.999-99 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx AAA-9999 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx 99/99/9999 99:99
            System.out.println("--------------------------------------------------------------------------------");
            
            for (var locacao : locacoes) {
                System.out.printf("%s %-30s %-8s %-30s %s\n", 
                        formataCPF(locacao.getCpfCliente().valor), 
                        locacao.getNomeCliente(), 
                        locacao.getPlacaVeiculo(),
                        locacao.getModeloVeiculo(),
                        formataDataHora(locacao.getDataHora()));
            }
            
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    public void mostrarErro() {
        System.out.println("Erro no acesso aos dados. Tente novamente ou procure o suporte!");
    }

    private String formataCPF(Long cpf) {
        return String.format("%011d", cpf).replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    private String formataDataHora(LocalDateTime dataHora) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataHora.format(formatter);
    }
}
