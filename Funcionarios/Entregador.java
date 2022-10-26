package Funcionarios;
import java.util.ArrayList;

import Models.Funcionario;
import Models.TipoFuncionario;

public class Entregador extends Funcionario{

    private int espera;
    private int tolerancia;
    private int contCancelados;
    private int contQuaseCancelados;
    private int contEntregues;
    private ArrayList<Entregador> entregadores;

    public Entregador(String nome, TipoFuncionario tipoFuncionario, int idFuncionario, boolean isEmpty,
            int qtdPedidos) {
        super(nome, tipoFuncionario, idFuncionario, isEmpty, qtdPedidos);

        contCancelados = 0;

        Entregador entregador1 = new Entregador("entregador1", TipoFuncionario.ENTREGADOR, 1,true, 0);
        Entregador entregador2 = new Entregador("entregador1", TipoFuncionario.ENTREGADOR, 1, true, 0);
        Entregador entregador3 = new Entregador("entregador1", TipoFuncionario.ENTREGADOR, 1, true, 0);

        entregadores = new ArrayList<>();

        entregadores.add(entregador1);
        entregadores.add(entregador2);
        entregadores.add(entregador3);

    }
    
    public void processamentoEntregador(){
            for (Pedido pedido : filaDeEntrega) { 
                for (Funcionario funcionario : entregadores) {
                    if(funcionario.isEmpty()){
                        System.out.println("Seu pedido está a caminho...");
                        pedido.setFuncionarioStatus(funcionario); // Atribui um pedido à um funcionário 
                        tempoDeEntrega(pedido);
                        //TODO: fazer sleep com relação ao tempo de entrega
                        cancelado(pedido);
                        if(!cancelado(pedido))funcionario.setQtdPedidos(funcionario.getQtdPedidos()+1);//Incrementa o contador de pedidos do funcionário
                        filaDeEntrega.poll(); // Retira a head da fila de espera
                        System.out.printf("Processando %s", pedido.getNome());
                        break;
                    }else{
                        System.out.println("Não possuímos entregadores disponíveis no momentos. Aguarde.");
                    }
                }
            }
    
    }
    
    public boolean cancelado(Pedido p){
        
         if (!entregando(p)){
            if(p.getTempoDeEspera() > tolerencia(p)) {
            contCancelados++;
            return true;
            }
        }
        if((tolerencia(p) - p.getTempoDeEspera()) <= 2){
            contQuaseCancelados++;
            contEntregues++;
            return false;
        }
        contEntregues++; 
        return false;
    }

    public boolean entregando(Pedido pedido){
        if(entregadores.contains(pedido.getFuncionarioStatus())) return true;//Se o pedido já está com um entregador
        return false;
    }

    public int tempoDeEntrega(Pedido p){
        espera = p.getTempoDeEspera() + getRandom();
        p.setTempoDeEspera(espera);
        return espera;
    }

    public int tolerencia(Pedido pedido){
        tolerancia = pedido.getQtdProdutos() + 8;
        return tolerancia;
    }
}
