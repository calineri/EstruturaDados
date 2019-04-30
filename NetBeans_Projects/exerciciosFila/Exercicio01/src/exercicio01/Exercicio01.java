/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio01;

/**
 *
 * @author celal
 */
public class Exercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fila minhaFila = new Fila (4);
        //minhaFila.remove();
        minhaFila.insere(10);
        minhaFila.insere(20);
        minhaFila.insere(30);
        //minhaFila.insere(40);
        System.out.println(minhaFila.size());
        minhaFila.remove();
        System.out.println(minhaFila.size());
        minhaFila.insere(40);
        minhaFila.remove();
        minhaFila.remove();
        minhaFila.insere(50);
        minhaFila.insere(60);
        minhaFila.remove();
        minhaFila.remove();
        minhaFila.remove();
        minhaFila.insere(70);
        minhaFila.insere(80);
        minhaFila.insere(90);
        System.out.println(minhaFila.size());
        
    }
    
}
