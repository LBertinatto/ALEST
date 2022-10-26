package Funcionarios;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Models.Funcionario;
import Models.TipoFuncionario;

public class Separador extends Funcionario{
    private static Queue<Pedido> filaDeEntrega;
    private static Queue<Pedido> filaDeEspera;
    private ArrayList<Separador> separadores;
    private double espera;

    private int contPedidos;

    public Separador(String nome, TipoFuncionario tipoFuncionario, int idFuncionario, boolean isEmpty, int qtdPedidos) {
        super(nome, tipoFuncionario, idFuncionario, isEmpty, qtdPedidos);

        Separador seprador1 = new Separador("entregador1",TipoFuncionario.SEPARADOR, 1,true, 0);
        Separador seprador2 = new Separador("entregador2", TipoFuncionario.SEPARADOR, 2,true, 0);
        Separador seprador3 = new Separador("entregador3", TipoFuncionario.SEPARADOR, 3,true, 0);
        
        separadores = new ArrayList<>();

        separadores.add(seprador1);
        separadores.add(seprador2);
        separadores.add(seprador3);

        filaDeEntrega = new LinkedList<>();
        filaDeEspera = new LinkedList<>();

        contPedidos = 0;
    }
    
    public void processamentoSeparador(){
        for (Pedido pedido : filaDeEspera) {
            for (Funcionario funcionario : separadores) {
                if(funcionario.isEmpty()){
                    pedido.setFuncionarioStatus(funcionario);
                    break;
                    // Atribui um pedido à um funcionário através do setFuncionarioStatus
                }
            }
        }
        
        //TODO: Processamento do pedido (Verificar se tem funcionário livre, adicionar os tempos de espera e incrementar os contadores de pedido por funcionário )
    }

    public boolean recebePedido(Pedido p){
        filaDeEspera.add(p);
        contPedidos++;
        return true;
    } 

    public boolean pedidoSeparado(Pedido p){
        return true;
    }

    public boolean prontoParaEntrega(Pedido p){
       if(pedidoSeparado(p)){
        filaDeEntrega.add(p);
        return true;
     }
     return false;
    }

    public double tempoDeEsperaAleatorio(){
        espera = getRandom() * 1000;
        return espera;
    }

}
