package bombeiro;

public class Distrito {
	
    private int qtdRuas;
    private int qtdEsquinas;
    private int incendio;
    private int adj[][];
	
    public Distrito() {
        this.qtdRuas = 0;
        this.incendio = 0;
        
        // maximo de vertices - fixo pelo enunciado do trabalho
        this.qtdEsquinas=21;
        // máximo de vertices - fixo pelo enunciado do trabalho
        this.adj = new int[21][21];
    }
    
    public void insereIncendio(int incendio){
        this.incendio = incendio;
    }
    
    public String insereRua( int v, int w){
        String msgErro = "";
        
        if(v == w){
            msgErro = v + " " + w + " ==> Rua nao pode iniciar e finalizar na mesma esquina!";
        }
        
        if(this.adj[v][w]==0){
            this.adj[v][w]=1;
            this.qtdRuas++;
        }else{
            msgErro = v + " " + w + " ==> Rota ja inserida!";
        }
        return msgErro;
    }
    
    public void mostra(){
        for( int v=1; v < this.adj.length; v++){
            System.out.print(v+":");
            for( int w=1; w < this.adj[0].length; w++){
                if( this.adj[v][w]==1)
                    System.out.print(" "+w);
            }
            System.out.println();
        }
    }

}
