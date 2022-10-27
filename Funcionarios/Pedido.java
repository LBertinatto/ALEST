package Funcionarios;

import Models.Funcionario;
import Models.TipoEstado;

public class Pedido {
    private String nome;
    private Integer qtdProdutos;
    private Funcionario status;
    private int tempoDeEspera;
    private static boolean separado;
    private TipoEstado tipoEstado;

    public Pedido(String nome, int qtdProdutos, Funcionario status, int tempoDeEspera, TipoEstado tipoEstado) {
        this.nome = nome;
        this.qtdProdutos = qtdProdutos;
        this.status = status;
        this.tempoDeEspera = tempoDeEspera;
    }
    
    public String getNome() {
        return nome;
    }

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
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

    public static boolean isSeparado(Pedido p) {
        return separado;
    }

    public void setSeparado(boolean separado) {
        this.separado = separado;
    }

}
