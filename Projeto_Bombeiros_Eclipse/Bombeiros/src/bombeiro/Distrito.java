/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre.
 * 
 * */
package bombeiro;

public class Distrito {
	
    private int qtdRuas; // Quantidade de arestas
    private int esquinas[]; // Quantidade de vertices
    private int incendio; // Armazena onde esta ocorrendo o incendio
    private int adj[][]; // Matriz de adjacencias
    private int caminhos[][]; // Matriz com os caminhos possiveis ate o incendio
    private int qtdRotas; // Quantidade de rotas encontradas ate o incendio
    
    // Construtor da classe distrito
    public Distrito(int tam) {
        this.qtdRuas = 0;
        this.incendio = 0;
        this.qtdRotas = 0;
        this.esquinas = new int[tam];
        this.adj = new int[tam][tam];
        this.caminhos = new int [tam][tam];
        
    }
    
    // Metodo para inserir em qual vertice ocorre o incendio
    public void insereIncendio(int incendio){
        this.incendio = incendio;
    }
    
    // Metodo para obter o vertice onde ocorre o incendio
    public int getIncendio() {
    	return this.incendio;
    }
    
    // Metodo obtem a quantidade de arestas
    public int getQtdRuas() {
    	return this.qtdRuas;
    }
    
    // Metodo obtem a quantidade de vertices
    public int getEsquinas() {
    	int qtd = 0;
    	for(int i = 1; i<esquinas.length; i++) {
    		if (esquinas[i]>0) {
    			qtd++;
    		}
    	}
    	return qtd;
    }
    
    // Metodo obtem a quantidade de rotas possiveis
    // entre a origem (quartel de bombeiros) e o incendio
    public int getQtdRotas(){
        return this.qtdRotas;
    }
    
    // Metodo devolve matriz com todos os caminhos possiveis
    // entre a origem (quartel de bombeiros) e o incendio
    public int[][] getCaminhos(int pontoPartida){
    	Pilha pilha = new Pilha(this.esquinas.length);
    	this.buscaCaminho(pontoPartida, this.incendio, pilha);    	
    	return this.caminhos;
    }
    
    /* Metodo insere aresta e efetua as seguintes validacoes:
       1- Uma aresta nao pode iniciar e finalizar no mesmo vertice
       2- Uma aresta nao pode ser direcionada para o vertice 1 (Quartel bombeiros)
       3- Nao podem conter arestas que criem um circulo fechado
       4- Nao pode inserir aresta mais de 1 vez para o mesmo par de vertices
    
       Caso ocorra alguma das situacoes citadas acima, eh devolvido mensagem de
       erro e impressa no console.
    */
    public String insereRua( int v, int w){
        String msgErro = "";
        boolean vis[] = new boolean[esquinas.length];
        
        if(v == w){
            msgErro = v + " " + w + " ==> Rua nao pode iniciar e finalizar na mesma esquina!";
        } else if (w == 1){
            msgErro = v + " " + w + " ==> Rua nao pode voltar ao corpo de bombeiros!";
        } else if (this.adj[v][w]==0){
            //testa se forma ciclo de w para v
            circuloFechado(w,vis);
            
            // se ja existe um caminho de w para v,
            // entao nao posso inserir uma aresta v-w
            if( vis[v] )
                msgErro = v + " " + w + " ==> Rota cria um ciclo fechado!";
            else{    
                this.adj[v][w]=1;
                this.esquinas[v]=1;
                this.esquinas[w]=1;
                this.qtdRuas++;
            }
        }else{
            msgErro = v + " " + w + " ==> Rota ja inserida!";
        }

        return msgErro;
    }
    
    
    // Funcao auxiliar para identificar um circulo fechado no grafo
    private void circuloFechado(int s, boolean vis[]){
        vis[s] = true;
        
        for(int t=0; t<this.adj.length; t++)
            // se t não foi visitado e existe aresta de s para t
            if (! vis[t] && this.adj[s][t] == 1)
                circuloFechado(t, vis);
        
    }
    
    // Funcao auxiliar para identificar os caminhos do quartel de bombeiros
    // ate o incendio
    private void buscaCaminho(int start, int end, Pilha pilha){
    	pilha.push(start);
        
        if (start != end){
            for(int t=0; t<this.adj.length; t++){
                if (this.adj[start][t] == 1){
                    buscaCaminho(t, end, pilha);
                    //int r = pilha.pop();
                    int elementos[] = pilha.getElementos();
                    if(elementos[pilha.getTopo()] == this.incendio){
                        for(int i=0; i<elementos.length; i++){
                            this.caminhos[this.qtdRotas][i] = elementos[i];
                        }
                        this.qtdRotas++;
                    }
                    pilha.pop();
                }
            }
        }
    }
    
    // Metodo que imprime no console as adjacencias do grafo
    public void mostra(){
        for( int v=1; v < this.adj.length; v++){
        	String msg = "";
            for( int w=1; w < this.adj[0].length; w++){
                if( this.adj[v][w]==1) {
                	if (msg.isEmpty()) {
                		msg = v + ":";
                	}
                    msg = msg + " " + w;
                }
            }
            if (!msg.isEmpty()) {
            	System.out.println(msg);
            }
        }
    }

}
