/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio05;

/**
 *
 * @author celso.alineri
 */
/**
 * Tipo Abstrato de Dados implementa a Estrutura de Dados Pilha
 */
public class Pilha {
    private char elementos[];
    private int topo;

    // Construtor da classe Pilha
    public Pilha(int tamanho) {
        // vetor para representar a Pilha
        // supondo que os elementos da Pilha sejam
        // caracteres
        elementos=new char[tamanho];
        // variável com o topo da Pilha
        // inicialmente a Pilha está vazia
        topo=-1;
    }
    //operação de empilhamento 
    public void push(char elemento){
        // sobe o topo
        topo++; 
        //insere o elemento no topo
        elementos[topo]=elemento;
    }
    //desempilhamento
    public char pop(){
        //retira elemento do topo
        char elemento=elementos[topo];
        // desce o topo da pilha
        topo--;
        return elemento;
    }
    public boolean isEmpty(){
        return topo == -1;
    }
    public boolean isFull(){
        return topo == elementos.length-1;
    }
    
}
