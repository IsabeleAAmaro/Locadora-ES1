package domain;

import java.util.ArrayList;
import java.util.List;

public class Veiculo extends Persistent
{
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double valorDiaria;
    private int quilometragem;

    public Veiculo(String placa, String modelo, int anoFabricacao, double valorDiaria, int quilometragem) {
        super();
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.valorDiaria = valorDiaria;
        this.quilometragem = quilometragem;
    }

    public static Resultado<Veiculo> create (String placa, 
                                            String modelo,
                                            int anoFabricacao, 
                                            double valorDiaria, 
                                            int quilometragem) {

        List<Erro> erros = new ArrayList<>();

        if (!placa.matches("[A-Z]{3}[0-9]{4}"))
            erros.add(Erro.PLACA_INVALIDA);
            
        if (modelo.length() < 3 || modelo.length() > 30)
            erros.add(Erro.MODELO_INVALIDO);
            
        if (anoFabricacao < 2000 || anoFabricacao > java.time.Year.now().getValue() ) 
            erros.add(Erro.ANO_FABRICACAO_INVALIDO);

        if (valorDiaria <=0 ) 
            erros.add(Erro.DIARIA_VALOR_INVALIDO);

        if (quilometragem <=0 ) 
            erros.add(Erro.QUILOMETRAGEM_INVALIDA);
        
        return erros.isEmpty() ?
            Resultado.ok(new Veiculo(placa, modelo, anoFabricacao, valorDiaria, quilometragem)) :
            Resultado.erro(erros);

    }

    public String getPlaca() {
        return placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}
