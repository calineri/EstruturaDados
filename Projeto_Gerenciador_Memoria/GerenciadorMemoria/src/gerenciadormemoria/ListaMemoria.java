/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre 2019.
 * 
 * */
package gerenciadormemoria;

public class ListaMemoria {
    
    private Bloco inicio;
    
    public ListaMemoria(){
        this.inicio = null;
    }
    
    public void addInicio(int endInicial, int qtdMemoria ){
        this.inicio = new Bloco(endInicial, qtdMemoria, this.inicio);
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
    
    
}
