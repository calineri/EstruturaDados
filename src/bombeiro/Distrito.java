package bombeiro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Distrito {
	
	private int rua;
	private int esquina;
	private int incendio;
	private int adj[][];
	
	public Distrito(int esq) {
		this.rua = 0;
		this.incendio = 0;
		this.esquina=esq;
		this.adj = new int[esq][esq];
	}
	
	// Constroi o distrito a partir de um arquivo
	public Distrito(String arq) throws FileNotFoundException, IOException{
		String linha;
		
		// Abre arquivo e efetua a primeira leitura
        FileReader arquivo = new FileReader(arq);
        BufferedReader leBuffer = new BufferedReader(arquivo);
        
        // O primeiro registro contem a esquina que esta ocorrendo incendio
        linha = leBuffer.readLine();
        this.incendio = Integer.decode(linha);
        
        //[TODO] Como identificar quantas arestas existem no arquivo?
        //this.adj = new int[?][?];
        
        // Demais registros do arquvo contem as coordenadas das arestas
        // Arquivo termina quando encontrar 0 0
        
        //[TODO] Trocar condicao de parada para identificar ultima linha do arquivo
        for(int i=0; i<this.esquina; i++){
            linha = leBuffer.readLine();
            String vet[] = linha.split(" ");
            this.adj[Integer.decode(vet[0])][Integer.decode(vet[1])] = 1;
        }
		
	}
	

}
