package Funcionarios;

import Models.Funcionario;

public class Pedido {
    private String nome;
    private Integer qtdProdutos;
    private Funcionario status;
    private double tempoDeEspera;

    public Pedido(String nome, int qtdProdutos, Funcionario status, double tempoDeEspera) {
        this.nome = nome;
        this.qtdProdutos = qtdProdutos;
        this.status = status;
        this.tempoDeEspera = tempoDeEspera;
    }
    
    public String getNome() {
        return nome;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public Funcionario getFuncionarioStatus(){
        return status;
    }

    public void setFuncionarioStatus(Funcionario status) {
        this.status = status;
    }

    public double getTempoDeEspera() {
        return tempoDeEspera;
    }

    public void setTempoDeEspera(double tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    
}
