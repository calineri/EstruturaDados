/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testagrafoencadeado;

/**
 *
 * @author celso.alineri
 */
public class Grafo {
    
    private final int v; // Contem o numero de vertices
    private int a; // Contem o numero de arestas
    private ListaLigada adj[]; // Guarda o inicio das listas de adjacencias
    
    public Grafo(int v){
        this.v = v;
        this.a = 0;
        this.adj = new ListaLigada[v];
        
        for(int i=0; i<v; i++){
            this.adj[i] = new ListaLigada();
        }
        
    }
    
    public void insereA(int v, int w){
        
        if(!this.adj[v].buscaLinearIterativa(w)){
            this.adj[v].addOrdenado(w);
            this.a +=1;
        }

    }
    
    public void removeA(int v, int w){
        
        if(this.adj[v].buscaLinearIterativa(w)){
            //parei aqui
        }
        
    }
    
    public void mostra(){
        for(int i=0; i<this.v; i++){
            System.out.println(i + ": " + this.adj[i]);
        }
    }
    
}
