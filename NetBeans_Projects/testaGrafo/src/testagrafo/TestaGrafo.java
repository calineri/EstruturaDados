package testagrafo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestaGrafo {
   public static void main(String[] args) throws FileNotFoundException, IOException{
       Grafo objGrafo;
       // instanciar um objeto da classe Grafo
       objGrafo = new Grafo(6);
       
       // insere a aresta 0-2
       objGrafo.insereA(0,2);
       objGrafo.insereA(0,4);
       objGrafo.insereA(0,3);       
       objGrafo.insereA(1,2);
       objGrafo.insereA(2,4);
       objGrafo.insereA(3,4);
       objGrafo.insereA(3,5);
       objGrafo.insereA(4,5);
       objGrafo.insereA(4,1);
       objGrafo.insereA(5,1);
       
       objGrafo.mostra();
       
       System.out.println("indeg(3):"+objGrafo.indeg(3));
       System.out.println("outdeg(3):"+objGrafo.outdeg(3));
       System.out.println("Verifica Fonte (0):"+objGrafo.fonte(0));
       
       /*
       Grafo objGrafo2 = constroi("entrada.txt");
       
       System.out.println();
       objGrafo2.mostra();
       */
       
       int seq[] = {0,1,4,5,3};
       System.out.println(objGrafo.isPath(seq));
       System.out.println("Eh caminho Simples?: " + objGrafo.simplePath(seq));
       System.out.println("Eh Caminho?: " + objGrafo.isPath(0, 1));
       
       objGrafo.exibeCaminho(0, 1);
       
    }
   
   public static Grafo constroi(String arq) throws FileNotFoundException, IOException{
       
       Grafo objGrafo2 = new Grafo(arq);
       return objGrafo2;
       
   }
    
}
