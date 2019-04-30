/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio03;

/**
 *
 * @author celso.alineri
 */
public class Exercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto = "este exercicio e muito facil.";
        System.out.println(invertePalavras(texto));
    }
    
    public static String invertePalavras(String texto){
        String ret="";
        Pilha pilha = new Pilha(texto.length());
        for(int i=0; i < texto.length(); i++){
            if(texto.charAt(i) != ' ' && texto.charAt(i) != '.'){
                pilha.push(texto.charAt(i));
            } else {
                while(!pilha.isEmpty()){
                    ret = ret + pilha.pop();
                }
                ret = ret + texto.charAt(i);
            }
        }

        return ret;
    }
    
}
