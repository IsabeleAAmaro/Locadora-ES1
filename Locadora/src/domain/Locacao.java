package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Locacao extends Persistent {

    private CPF cpfCliente;
    private String nomeCliente;
    private String placaVeiculo;
    private String modeloVeiculo;
    private LocalDateTime dataHora;

    public Locacao(CPF cpfCliente, String placaVeiculo, LocalDateTime dataHora) {
        super();
        this.cpfCliente = cpfCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataHora = dataHora;
    }

    public Locacao(CPF cpfCliente, String nomeCliente, String placaVeiculo, String modeloVeiculo, LocalDateTime dataHora) {
        super();
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.placaVeiculo = placaVeiculo;
        this.dataHora = dataHora;
        this.modeloVeiculo = modeloVeiculo;
    }

    public static Resultado<Locacao> create(Long cpfCliente, String placaVeiculo, LocalDateTime data_hora) {
        List<Erro> erros = new ArrayList<>();
        CPF cpf = CPF.create(cpfCliente);

        if (cpf == null)
            erros.add(Erro.CPF_INVALIDO);

        if(placaVeiculo == null || !placaVeiculo.matches("[A-Za-z]{3}\\d{4}"))
            erros.add(Erro.PLACA_INVALIDA);

        if (data_hora == null)
            erros.add(Erro.DATA_INVALIDA);

        return erros.isEmpty() ? Resultado.ok(new Locacao(cpf, placaVeiculo, data_hora)) : Resultado.erro(erros);
    }

    public static Resultado<Locacao> create(Long cpfCliente, String nomeCliente, String placaVeiculo, String modeloVeiculo, LocalDateTime dataHora) {
        List<Erro> erros = new ArrayList<>();
        
        CPF cpf = CPF.create(cpfCliente);

        //TODO: Verificação do CPF

        if(placaVeiculo == null || !placaVeiculo.matches("[A-Za-z]{3}\\d{4}"))
            erros.add(Erro.PLACA_INVALIDA);

        if (dataHora == null)
            erros.add(Erro.DATA_INVALIDA);

        return erros.isEmpty() ? Resultado.ok(new Locacao(cpf, nomeCliente, placaVeiculo, modeloVeiculo, dataHora)) : Resultado.erro(erros);
    }

    public CPF getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(CPF cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
}
