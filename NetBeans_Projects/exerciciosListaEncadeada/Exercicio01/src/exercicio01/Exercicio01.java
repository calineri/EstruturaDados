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
        ListaLigada lista = new ListaLigada();
        
        lista.addInicio(10);
        lista.addInicio(20);
        lista.addInicio(30);
        lista.addInicio(40);
        lista.addInicio(50);
        
        System.out.println(lista.buscaLinearIterativa(30));
        System.out.println(lista.buscaLinearRecursiva(30));
    }
    
}
