package bombeiro;

public class Distrito {
	
    private int qtdRuas;
    private int esquinas[];
    private int incendio;
    private int adj[][];
	
    public Distrito() {
        this.qtdRuas = 0;
        this.incendio = 0;
        
        // maximo de vertices - fixo pelo enunciado do trabalho
        this.esquinas = new int[21];
        // maximo de vertices - fixo pelo enunciado do trabalho
        this.adj = new int[21][21];
    }
    
    public void insereIncendio(int incendio){
        this.incendio = incendio;
    }
    
    public int getIncendio() {
    	return this.incendio;
    }
    
    public int getQtdRuas() {
    	return this.qtdRuas;
    }
    
    public int getEsquinas() {
    	int qtd = 0;
    	for(int i = 1; i<esquinas.length; i++) {
    		if (esquinas[i]>0) {
    			qtd++;
    		}
    	}
    	return qtd;
    }
    
    public String insereRua( int v, int w){
        String msgErro = "";
        
        if(v == w){
            msgErro = v + " " + w + " ==> Rua nao pode iniciar e finalizar na mesma esquina!";
        } else if (this.adj[v][w]==0){
            this.adj[v][w]=1;
            this.esquinas[v]=1;
            this.esquinas[w]=1;
            this.qtdRuas++;
        }else{
            msgErro = v + " " + w + " ==> Rota ja inserida!";
        }

        return msgErro;
    }
    
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
