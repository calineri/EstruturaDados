/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testagrafoencadeado;

/**
 *
 * @author celso.alineri
 */
public class TestaGrafoEncadeado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);
        
        grafo.insereA(0, 1);
        grafo.insereA(0, 2);
        grafo.insereA(2, 1);
        grafo.insereA(1, 3);
        grafo.insereA(2, 3);
        
        grafo.mostra();
    }
    
}
