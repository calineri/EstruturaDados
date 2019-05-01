/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre.
 * 
 * */
package bombeiro;

public class Pilha {
    private int elementos[];
    private int topo;

    // Construtor da classe Pilha
    public Pilha(int tamanho) {
        // vetor para representar a Pilha
        // supondo que os elementos da Pilha sejam
        // caracteres
        this.elementos=new int[tamanho];
        // variavel com o topo da Pilha
        // inicialmente a Pilha esta vazia
        this.topo=-1;
    }
    
    // Metodo devolve os elementos da pilha sem desempilhar (efetua Browse)
    public int[] getElementos() {
        int element[] = new int[this.elementos.length];
        
        for(int i=0; i<=this.topo; i++){
            element[i] = elementos[i];
        }
        
    	return element;
    }
    
    // Metodo obtem o indice que aponta o topo da pilha
    public int getTopo() {
    	return this.topo;
    }
    
    //Metodo efetua a operacao de empilhamento 
    public void push(int elemento){
        // sobe o topo
        this.topo++; 
        //insere o elemento no topo
        this.elementos[this.topo]=elemento;
    }
    
    //Metodo efetua desempilhamento
    public int pop(){
        //retira elemento do topo
        int elemento = this.elementos[topo];
        // desce o topo da pilha
        this.topo--;
        return elemento;
    }
    
    // Metodo verifica se a pilha esta vazia
    public boolean isEmpty(){
        return this.topo == -1;
    }
    
    // MEtodo verifica se a pilha esta cheia
    public boolean isFull(){
        return this.topo == elementos.length-1;
    }
    
}
