/*
 * Escreva uma versão recursiva para a função bemFormada(), 
 * sem a utilização de uma Pilha como estrutura de dados.
 */
package exercicio02;

/**
 * @author celso.alineri
 */
public class Exercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String entrada="((([])))";
        
        if( bemFormada( entrada, 0 ))
            System.out.println("entrada "+entrada+" esta bem formada.");
        else
            System.out.println("entrada "+entrada+" NAO esta bem formada.");
    }
    
    private static boolean bemFormada(String entrada, int i) {
        boolean ret = false;
        if (entrada.isEmpty()){
            ret = false;
        }
                
        if (entrada.charAt(i)=='('||entrada.charAt(i)=='['){
            ret = bemFormada(entrada, i+1);
        }
        
        if (entrada.charAt(i)==')'||entrada.charAt(i)==']'){
            
        }
        
        
        return ret;
    }
}
