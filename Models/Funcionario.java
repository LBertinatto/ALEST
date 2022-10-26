package Models;

import java.util.Random;

public abstract class Funcionario{
    private String nome;
    private int idFuncionario;
    private boolean isEmpty;
    private int qtdPedidos;
    private TipoFuncionario tipoFuncionario;
    private Random random;

    public Funcionario(String nome, TipoFuncionario tipoFuncionario, int idFuncionario, boolean isEmpty, int qtdPedidos){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getQtdPedidos() {
        return qtdPedidos;
    }

    public double getRandom() {
        random = new Random();
        double r = random.nextLong(10);
        return r;
    }

    public void setQtdPedidos(int qtdPedidos) {
        this.qtdPedidos = qtdPedidos;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    
}
