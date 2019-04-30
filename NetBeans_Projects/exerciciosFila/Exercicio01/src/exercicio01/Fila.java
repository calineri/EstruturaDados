package exercicio01;
// implementacao de uma fila não circular, com exceções
// para maiores informações acessem
// https://www.devmedia.com.br/trabalhando-com-excecoes-em-java/27601
/**
 *
 * @author fabio.aglubacheski
 */
public class Fila {
    private int first, last, qtd, N;
    private int elementos[];

    public Fila(int N) {
        this.first = 0;
        this.last = 0;
        this.qtd = 0;
        this.N = N;
        elementos = new int[N];
        
    }
    public void insere( int elemento ){
        if( !isFull()){
            this.elementos[this.last] = elemento;
            this.last = (this.last+1)%this.N;
            qtd++;
        }
        else
            throw new RuntimeException("Fila cheia !");
    }
    public int remove( ){
        int elemento=-1;
        if( ! isEmpty() ){
            elemento = this.elementos[this.first];
            this.first= (this.first+1)%this.N;
            qtd--;
        }
        else
            throw new RuntimeException("Fila vazia !");
        
        return elemento;
    }
    public boolean isEmpty(){
        return this.first == this.last;
    }
    public boolean isFull(){
        return (this.last+1)%this.N==this.first;
               
        
        //return this.last == elementos.length;
    }
    // calcula o numero de elementos na Fila
    public int size(){
        return qtd;
    }
    
}
