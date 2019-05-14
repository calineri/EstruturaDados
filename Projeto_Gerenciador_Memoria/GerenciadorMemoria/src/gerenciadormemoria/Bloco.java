/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre 2019.
 * 
 * */
package gerenciadormemoria;

public class Bloco {
    private int endInicial;
    private int qtdMemoria;
    private Bloco prox;
    
    public Bloco(int endInicial, int qtdMemoria, Bloco prox){
        this.endInicial = endInicial;
        this.qtdMemoria = qtdMemoria;
        this.prox = prox;
    }

    public int getEndInicial() {
        return endInicial;
    }

    public void setEndInicial(int endInicial) {
        this.endInicial = endInicial;
    }

    public int getQtdMemoria() {
        return qtdMemoria;
    }

    public void setQtdMemoria(int qtdMemoria) {
        this.qtdMemoria = qtdMemoria;
    }

    public Bloco getProx() {
        return prox;
    }

    public void setProx(Bloco prox) {
        this.prox = prox;
    }
    
    @Override
    public String toString() {
        return "{" + this.endInicial + "," + this.qtdMemoria + "," + this.prox + '}';
    }
    
}
