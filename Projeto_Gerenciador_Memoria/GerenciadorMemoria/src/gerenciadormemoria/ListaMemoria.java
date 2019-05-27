/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre 2019.
 * 
 * */
package gerenciadormemoria;

public class ListaMemoria {
    
    private Bloco inicio;
    private int qtdBlocos;
    
    public ListaMemoria(){
        this.inicio = null;
        this.qtdBlocos = 0;
    }
    
    public void addInicio(int qtdMemoria){
        this.inicio = new Bloco(qtdMemoria, this.inicio);
        this.qtdBlocos += 1;
    }
    
    public Bloco remInicio(){
        if(!this.isEmpty()){
            Bloco ret = this.inicio;
            this.inicio = inicio.getProx();
            this.qtdBlocos -= 1;
            return ret;
        }else{
            throw new RuntimeException("Lista Vazia!");
        }
    }
    
    public boolean isEmpty(){
        return this.inicio == null;
    }
    
    public void addFim(int qtdMemoria) {
        Bloco aux = this.inicio;
        Bloco ant=null;
        while( aux !=null){
            ant = aux;
            aux = aux.getProx();
        }
        Bloco novo = new Bloco(qtdMemoria, null);
        if( ant == null )// insere  no inicio
            this.inicio = novo;
        else
            ant.setProx(novo);
        this.qtdBlocos += 1;
    }
    
    public void addOrdenadoAlocado(int numProc, int tamMemoria, Bloco livre) {
        Bloco aux = this.inicio;
        Bloco ant = null;
        while( aux != null && aux.getNumeroProcesso() < numProc){
            ant = aux;
            aux = aux.getProx();
        }
        Bloco novo = new Bloco(numProc, livre.getEndInicial(), tamMemoria, aux);
        if( ant == null )// insere  no inicio
            this.inicio = novo;
        else
            ant.setProx(novo);
        this.qtdBlocos += 1;
    }
    
    public void addOrdenadoLivre(int endInicial, int tamMemoria) {
        Bloco aux = this.inicio;
        Bloco ant = null;
        while( aux != null && aux.getEndInicial() < endInicial){
            ant = aux;
            aux = aux.getProx();
        }
        Bloco novo = new Bloco(endInicial, tamMemoria, aux);
        if( ant == null )// insere  no inicio
            this.inicio = novo;
        else
            ant.setProx(novo);
        this.qtdBlocos += 1;
        desfragmentaLivre();
        
    }
    
    public Bloco verMemLivre(int tam){
        Bloco aux = this.inicio;
        
        while (aux != null){
            if(tam <= aux.getQtdMemoria()){
                return aux;
            }
            aux = aux.getProx();
        }
        
        return null;
    }
    
    public void subtrai(int tam, Bloco livre){
        livre.setQtdMemoria(livre.getQtdMemoria() - tam);
        livre.setEndInicial(livre.getEndInicial() + tam);
        
        if(livre.getQtdMemoria() <= 0){
            removeLivre(livre.getEndInicial());
        }
        
    }
    
    public int getQtdBlocos(){
        return this.qtdBlocos;
    }
    
    public Bloco getBloco(int idx){
        Bloco aux = this.inicio;
        int i=0;
        
        while (aux != null && i < idx){
            aux = aux.getProx();
            i++;
        }
        
        return aux;
    }
    
    public boolean buscaProcessoIgual(int elemento){
        
        return buscaProcesso(elemento, this.inicio);
    }
    
    private boolean buscaProcesso(int x, Bloco aux){
        // Condicoes de parada
        if(aux == null){
            return false;
        }
        
        if(aux.getNumeroProcesso() == x){
            return true;
        }
        
        // Diminui entrada e faz recursividade
        return buscaProcesso(x, aux.getProx());
    }
    
    public Bloco removeAlocado(int proc){
        Bloco aux = this.inicio;
        Bloco ant = null;
        while(aux != null && aux.getNumeroProcesso() != proc){
            ant = aux;
            aux = aux.getProx();
        }
        
        if(ant == null){
            this.inicio = aux.getProx();
        }else{
            ant.setProx(aux.getProx());
        }
        this.qtdBlocos -= 1;
        return aux;
    }
    
    private void removeLivre(int endInicial){
        Bloco aux = this.inicio;
        Bloco ant = null;
        while(aux != null && aux.getEndInicial() != endInicial){
            ant = aux;
            aux = aux.getProx();
        }
        
        if(ant == null){
            this.inicio = aux.getProx();
        }else{
            ant.setProx(aux.getProx());
        }
        this.qtdBlocos -= 1;
    }
    
    private void desfragmentaLivre(){
        Bloco aux = this.inicio;
        Bloco ant = null;
        
        while(aux != null){
            int val = aux.getEndInicial() + aux.getQtdMemoria();
            if(aux.getProx() != null && aux.getProx().getEndInicial() == val){
                aux.getProx().setEndInicial(aux.getEndInicial());
                aux.getProx().setQtdMemoria(aux.getQtdMemoria() + aux.getProx().getQtdMemoria());
                
                if(ant == null){
                    this.inicio = aux.getProx();
                    aux = this.inicio;
                }else{
                    ant.setProx(aux.getProx());
                    //ant = aux;
                    aux = aux.getProx();
                }
                this.qtdBlocos -= 1;
                
            }else{
                ant = aux;
                aux = aux.getProx();
            }
        }
    }
    
    @Override
    public String toString() {
        return this.inicio+"";
    }
    
}
