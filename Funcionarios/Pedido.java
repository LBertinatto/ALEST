package Funcionarios;

import Models.Funcionario;

public class Pedido {
    private String nome;
    private Integer qtdProdutos;
    private Funcionario status;
    private int tempoDeEspera;

    public Pedido(String nome, int qtdProdutos, Funcionario status, int tempoDeEspera) {
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

    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    public void setTempoDeEspera(int tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    
}
