/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testagrafoencadeado;

/**
 *
 * @author celal
 */
public class ListaLigada {
    private No inicio;// endereço inicial da lista

    public ListaLigada(){
        this.inicio = null; // lista esta vazia
    }
    
    public void addInicio( int elemento ){
        this.inicio = new No(elemento,this.inicio);
    }
    
    public int remInicio(){
        if(!this.isEmpty()){
            int ret = this.inicio.getElemento();
            this.inicio = inicio.getProx();
            return ret;
        }else{
            throw new RuntimeException("Lista Vazia!");
        }
    }
    
    public boolean isEmpty(){
        return this.inicio == null;
    } 
    
    public boolean buscaLinearIterativa(int elemento){
        No aux = this.inicio;
        
        while(aux != null){
            if (aux.getElemento() == elemento){
                return true;
            }else{
                aux = aux.getProx();
            }
        }
        return false;
    }
    
    public boolean buscaLinearRecursiva(int elemento){
        
        return busca(elemento, this.inicio);
    }
    
    private boolean busca(int x, No aux){
        // Condicoes de parada
        if(aux == null){
            return false;
        }
        
        if(aux.getElemento() == x){
            return true;
        }
        
        // Diminui entrada e faz recursividade
        return busca(x, aux.getProx());
    }
    
    public void addFim(int x) {
        No aux = this.inicio;
        No ant=null;
        while( aux !=null){
            ant = aux;
            aux = aux.getProx();
        }
        No novo = new No(x, null);
        if( ant == null )// insere  no inicio
            this.inicio = novo;
        else
            ant.setProx(novo);
        
    }
    
    public void addOrdenado(int x) {
        No aux = this.inicio;
        No ant=null;
        while( aux !=null&&aux.getElemento()<x){
            ant = aux;
            aux = aux.getProx();
        }
        No novo = new No(x, aux);
        if( ant == null )// insere  no inicio
            this.inicio = novo;
        else
            ant.setProx(novo);
        
    }
    
    public void remOrdenado(int x) {
        No aux = this.inicio;
        No ant=null;
        while( aux !=null&&aux.getElemento()!=x){
            ant = aux;
            aux = aux.getProx();
        }
        
        if( ant == null )// insere  no inicio
            this.inicio = aux.getProx();
        else
            ant.setProx(aux.getProx());
        
    }
    
    @Override
    public String toString() {
        return this.inicio+"";
    }
    
}
