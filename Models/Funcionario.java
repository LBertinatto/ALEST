package Models;

import java.util.ArrayList;
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

    public int getRandom() {
        random = new Random();
        int r = random.nextInt(12);
        if((r+1)<4) r=3;
        return r+1;
    }

    public void setQtdPedidos(int qtdPedidos) {
        this.qtdPedidos = qtdPedidos;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    
}
