package Funcionarios;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Models.Funcionario;
import Models.TipoFuncionario;

public class Entregador extends Funcionario{
    
    private int espera;
    private int tolerancia;
    private int contEntregasSolicitadas = 0;
    private int contCancelados = 0;
    private int contQuaseCancelados = 0;
    private int contEntregues = 0;
    private boolean prontoParaEntrega;
    private ArrayList<Entregador> entregadores;
    private static Queue<Pedido> filaDeEntrega;

    public Entregador(String nome, TipoFuncionario tipoFuncionario, int idFuncionario, boolean isEmpty,
            int qtdPedidos) {
        super(nome, tipoFuncionario, idFuncionario, isEmpty, qtdPedidos);

        Entregador entregador1 = new Entregador("entregador1", TipoFuncionario.ENTREGADOR, 1,true, 0);
        Entregador entregador2 = new Entregador("entregador1", TipoFuncionario.ENTREGADOR, 1, true, 0);
        Entregador entregador3 = new Entregador("entregador1", TipoFuncionario.ENTREGADOR, 1, true, 0);

        entregadores = new ArrayList<>();
        filaDeEntrega = new LinkedList<>();

        entregadores.add(entregador1);
        entregadores.add(entregador2);
        entregadores.add(entregador3);
    }
    
    public void processamentoEntregador(){
                for (Funcionario funcionario : entregadores) {
                    Pedido head = filaDeEntrega.remove();
                    if(funcionario.isEmpty() && isProntoParaEntrega(head)){
                        System.out.println("Seu pedido está a caminho...");

                        head.setFuncionarioStatus(funcionario); // Atribui um pedido à um funcionário 

                         funcionario.setEmpty(false); //Ocupa o funcionário
                        tempoDeEntrega(head);

                        //TODO: fazer sleep com relação ao tempo de entrega

                        cancelado(head);
                        
                        if(!cancelado(head))funcionario.setQtdPedidos(funcionario.getQtdPedidos()+1);//Incrementa o contador de pedidos do funcionário
                        
                        filaDeEntrega.poll(); // Retira a head da fila de espera
                        System.out.printf("Processando %s", head.getNome());
                        break;
                    }else{
                        System.out.println("Não possuímos entregadores disponíveis no momentos. Aguarde.");
                    }
            }
    
    }
    
    public boolean cancelado(Pedido p){
        
         if (!entregando(p)){
            if(p.getTempoDeEspera() > tolerencia(p)) {
            contCancelados++;
            return true;
            }
        
        if((tolerencia(p) - p.getTempoDeEspera()) <= 2){
            contQuaseCancelados++;
            contEntregues++;
            return false;
        }
    
        contEntregues++; 
    }
            return false;
    }

    public boolean entregando(Pedido pedido){
        if(entregadores.contains(pedido.getFuncionarioStatus()) && filaDeEntrega.contains(pedido)) return true;//Se o pedido já está com um entregador e o pedido ainda está na fila de entrega
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

    public boolean isProntoParaEntrega(Pedido p) {
        if(Pedido.isSeparado(p)){
            filaDeEntrega.add(p);
            contEntregasSolicitadas++;
            return true;
         }
         return false;
    }
}
