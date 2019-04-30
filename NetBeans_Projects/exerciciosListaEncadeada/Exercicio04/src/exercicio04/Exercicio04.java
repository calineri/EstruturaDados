/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio04;

/**
 *
 * @author celso.alineri
 */
public class Exercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        
        lista.addOrdenado(50);
        lista.addOrdenado(20);
        lista.addOrdenado(40);
        lista.addOrdenado(30);
        lista.addOrdenado(10);
        lista.addOrdenado(5);
        lista.addOrdenado(60);
        
        System.out.println(lista);
    }
    
}
