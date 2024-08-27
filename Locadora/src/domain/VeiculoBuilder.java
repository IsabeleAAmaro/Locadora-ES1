package domain;

import java.util.ArrayList;
import java.util.List;

public class VeiculoBuilder {

    private String placa;
    private String modelo;
    private int anoFabricacao;
    private double valorDiaria;
    private int quilometragem;

    public VeiculoBuilder(){}

    public VeiculoBuilder withPlaca (String placa){
        this.placa = placa;
        return this;
    }

    public VeiculoBuilder withModelo (String modelo){
        this.modelo = modelo;
        return this;
    }

    public VeiculoBuilder withAnoFabr (int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
        return this;
    }

    public VeiculoBuilder withDiaria (double valorDiaria){
        this.valorDiaria = valorDiaria;
        return this;
    }

    public VeiculoBuilder withKM (int quilometragem){
        this.quilometragem = quilometragem;
        return this;
    }
    
    public Resultado<Veiculo> build()
    {
        List<Erro> erros = new ArrayList<>();
        
        var resultVeiculo = Veiculo.create( placa, 
                                            modelo, 
                                            anoFabricacao, 
                                            valorDiaria, 
                                            quilometragem);

        if (resultVeiculo.falha())
            erros.addAll(resultVeiculo.erros);

        return erros.isEmpty() ?
            Resultado.ok(resultVeiculo.valor) : 
            Resultado.erro(erros);
    
    }
}
