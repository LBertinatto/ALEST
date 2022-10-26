package Funcionarios;
import java.util.ArrayList;

import Models.Funcionario;
import Models.TipoFuncionario;

public class Entregador extends Funcionario{

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
        //TODO: Processamento do pedido (Verificar se tem funcionário livre, adicionar os tempos de espera e incrementar os contadores de pedido por funcionário )
    }
    
    public boolean cancelado(Pedido p){
        //TODO: Definir tempo de espera, tolerância e quase cancelado
        /*
         * if (!entregando()){
         * if(tempoDeEspera > tolerencia) {
         * contCancelados++;
         * return true;
         * }
         * }
         * 
         * if((tolerancia - tempoDeEspera) <= x){
         * contQuaseCancelado++;
         * contEntregues++;
         * return false
         * }
         * 
         * qtdPedidos do funcionario++;
         * contEntregues++;
         */ 
        return false;
    }

    public boolean entregando(){
        return false;
    }
}
