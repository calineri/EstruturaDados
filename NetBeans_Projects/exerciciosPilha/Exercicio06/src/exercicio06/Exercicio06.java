/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio06;

/**
 *
 * @author celal
 */
public class Exercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero = 18;
        
        System.out.println("Numero " + numero + " em binario = " + converteBinario(numero));
    }
    
    public static int converteBinario(int numero){
        int binario=0;
        // Fixo - converte valores decimais ate o numero 255
        Pilha p = new Pilha(8);
        
        while(numero != 0){
            p.push(numero%2);
            numero = numero/2;
        }
       
        
        while(!p.isEmpty()){
            binario = (binario * 10) + p.pop();
        }
        
        return binario;
    }
}
