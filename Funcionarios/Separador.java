package Funcionarios;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Models.Funcionario;
import Models.TipoFuncionario;

public class Separador extends Funcionario{
    
    private static Queue<Pedido> filaDeEspera;
    private ArrayList<Separador> separadores;

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

        filaDeEspera = new LinkedList<>();

        contPedidos = 0;
    }
    
    public void processamentoSeparador(){
            for (Funcionario funcionario : separadores) {
                Pedido head2 = filaDeEspera.element();

                if(funcionario.isEmpty()){
                    head2.setFuncionarioStatus(funcionario); // Atribui um pedido à um funcionário 
                    funcionario.setEmpty(false); //Ocupa o funcionário
                    System.out.println("Um funcionário separador recebeu seu pedido...");

                    head2.setTempoDeEspera(head2.getQtdProdutos()); // Cada produto demora 1 ciclo(int)
                    funcionario.setQtdPedidos(funcionario.getQtdPedidos()+1);//Incrementa o contador de pedidos do funcionário

                    filaDeEspera.poll(); //Retira a head da fila de espera

                    System.out.printf("Processando %s...", head2.getNome());
                    //TODO: fazer um sleep com relação ao getTempoDeEspera()
                   
                    head2.setSeparado(true); //Retorna separado como true
                    
                    System.out.println("Adicionando à Fila de Entrega...");
                    break;
                }else{
                    System.out.println("Não possuímos separadores disponíveis no momento. Aguarde.");
                }
            }
        }

    public boolean recebePedido(Pedido p){
        filaDeEspera.add(p);
        contPedidos++;
        return true;
    } 

}
