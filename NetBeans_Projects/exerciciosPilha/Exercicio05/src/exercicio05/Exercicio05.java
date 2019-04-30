/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio05;

/**
 *
 * @author celal
 */
public class Exercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String palavra = "babacabab";
        
        System.out.println("Esta no formato certo?: " + verFormato(palavra));
    }
    
    public static boolean verFormato(String palavra){
        Pilha p = new Pilha(palavra.length());
        int i = 0;
        
        while(i < palavra.length() && palavra.charAt(i) != 'c'){
            p.push(palavra.charAt(i));
            i++;
        }
        
        i++;
        
        if(p.isEmpty()){
            return false;
        }
        
        while(!p.isEmpty() && i < palavra.length()){
            if(palavra.charAt(i) != p.pop()){
                return false;
            }
            i++;
        }
        
        if(!p.isEmpty()){
            return false;
        }
        
        if(i != palavra.length()){
            return false;
        }
        
        return true;
    }
}
