import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grafo {
    private int V; // número de vértices
    private int A; // número de arestas
    private int adj[][]; // matriz de adjcência

    // inicializa os atributos da classe e cria a 
    // matriz de adjacência para V vértices
    public Grafo( int V ){
        this.V = V;
        this.A = 0; // nao tenho nenhuma aresta
        // criar a matriz de adjacencia
        adj = new int[V][V];
    }
    /*
    Método insere uma aresta v-w no grafo. O método supõe 
    que v e w são distintos, positivos e menores que V. 
    Se o grafo já tem aresta v-w, o método não faz nada, 
    após a inserção da aresta, o atributo A da classe é 
    atualizado.
    */
    public void insereA( int v, int w){
        if(this.adj[v][w]==0){
            this.adj[v][w]=1;
            this.A++;
        }
    }
    /*
    Para cada vértice v do grafo, este método imprime, 
    em uma linha, todos os vértices adjacentes a v. 
    */
    public void mostra( ){
        for( int v=0; v < this.V; v++){
            System.out.print(v+":");
            for( int w=0; w < this.V; w++){
                if( this.adj[v][w]==1)
                    System.out.print(" "+w);
                    
            }
            System.out.println();
        }
    }
    // calcula o grau de entrada de um vértice
    public int indeg( int v ){
        int grauEntrada = 0;
        for( int i=0; i < this.V; i++)
            grauEntrada+=this.adj[i][v];
        
        return grauEntrada;
            
    }
    // calcula o grau de saída de um vértice
    public int outdeg( int v ){
        int grauSaida = 0;
        for( int i=0; i < this.V; i++)
            grauSaida+=this.adj[v][i];
        
        return grauSaida;
            
    }
    // verifica se um vértice é uma fonte. Se sim retorna TRUE, senao FALSE
    public boolean fonte( int v ){
        for( int i=0; i < this.adj.length; i++){
            if(this.adj[i][v] > 0){
                return false;
            }
        }
        return true;
    }
    // metodo constroi um grafo a partir de um arquivo informado no parametro
    public void constroi(String arq) throws FileNotFoundException, IOException{
        String linha;
        
        // Abre arquivo e efetua a primeira leitura
        FileReader arquivo = new FileReader(arq);
        BufferedReader leBuffer = new BufferedReader(arquivo);
        
        // O primeiro registro do arquivo contem o número de vértices do grafo
        linha = leBuffer.readLine();
        this.V = Integer.decode(linha);
        
        // O segundo registro do arquivo contem o número de arestas do grafo
        linha = leBuffer.readLine();
        this.A = Integer.decode(linha);
        
        // Demais registros do arquvo contem as coordenadas das arestas
        for(int i=0; i<this.A; i++){
            linha = leBuffer.readLine();
            String vet[] = linha.split(" ");
            this.adj[Integer.decode(vet[0])][Integer.decode(vet[1])] = 1;
        }
        
    }
    // metodo identifica se a lista de vertices eh um caminho
    public boolean isPath(int seq[]){
       
       for(int v=0,w = 1; w<seq.length; v++,w++){
          if (this.adj[seq[v]][seq[w]] != 1){
             return false;
          }
       }
       
       return true;
    }
    // metodo identifica se eh um caminho simples
    public int simplePath(int seq[]){

       if(this.isPath(seq)){
          for(int i=0; i<seq.length;i++){
             for(int j=i+1; j<seq.length; j++){
                if(seq[i] == seq[j]){
                   return 1;
                }
             }
          }
          return 0;
          
       }
       return -1;
       
    }

}
