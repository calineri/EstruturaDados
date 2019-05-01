/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre.
 * 
 * */
package bombeiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bombeiro {

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	// fixo 21 que eh o tamanho maximo de esquinas no distrito
        Distrito distrito = new Distrito(21);
        
        // Constroi distrito a partir do arquivo de entrada
        constroiDistrito(distrito);
        
        System.out.println();
        
        // Obtem os caminhos a partir de um ponto de partida
        int caminhos[][] = distrito.getCaminhos(1);
        
        // Exibe as rotas encontradas no console
        if (distrito.getQtdRotas() > 0){
            System.out.println("Rotas encontradas: ");

            for (int i=0; i<=distrito.getQtdRotas(); i++){
                for(int j=0; j<caminhos[0].length; j++){
                    if(caminhos[i][j] != 0){
                        System.out.print(caminhos[i][j] + " ");
                    }
                }
                System.out.println();
            }
        
            System.out.println("Foram encontradas " + distrito.getQtdRotas() + " rotas do quartel de bombeiros até o incendio.");
        } else{
        // Caso nao existam rotas, sera exibida a mensagem abaixo
            System.out.println("Não foram encontradas rotas do quartel de bombeiros até o incendio.");
        }
        
    }
    
    // Funcao auxiliar para construir o grafo do Distrito a partir de um arquivo de entrada
    public static void constroiDistrito(Distrito d) throws FileNotFoundException, IOException {
        
        String linha;

        // Abre arquivo e efetua a primeira leitura
        FileReader arquivo = new FileReader("entrada.txt");
        BufferedReader leBuffer = new BufferedReader(arquivo);

        // O primeiro registro contem a esquina que esta ocorrendo incendio
        linha = leBuffer.readLine();
        d.insereIncendio(Integer.decode(linha));

        // Demais registros do arquvo contem as coordenadas das ruas
        // Arquivo termina quando encontrar 0 0

        linha = leBuffer.readLine();
        String vet[] = linha.split(" ");

        while(Integer.decode(vet[0]) != 0 && Integer.decode(vet[1]) != 0){
            String msgErro;
            msgErro = d.insereRua(Integer.decode(vet[0]), Integer.decode(vet[1]));
            
            if(!msgErro.isEmpty()){
                System.out.println(msgErro);
            }
            
            // Le a proxima linha
            linha = leBuffer.readLine();
            vet = linha.split(" ");
        }
        
        // Fecha arquivo
        leBuffer.close();
        
    }

}
