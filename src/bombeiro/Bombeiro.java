package bombeiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bombeiro {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Distrito distrito = new Distrito();
        
        constroiDistrito(distrito);
        
        distrito.mostra();
        
        System.out.println("Quantidade de esquinas: " + distrito.getEsquinas());
        
        //System.out.println("teste commit via Eclipse 2");
    }
    
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
            
            linha = leBuffer.readLine();
            vet = linha.split(" ");
        }
        
        // Fecha arquivo
        leBuffer.close();
        
    }

}
