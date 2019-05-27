/*Alunos : Wellington Maciel
 *         Celso Alineri
 *         
 *         Superior em Jogos digitais - 3o Semestre 2019.
 * 
 * */
package gerenciadormemoria;

import java.util.Scanner;

public class GerenciadorMemoria {

    public static void main(String[] args) {
        
        boolean fimProcessamento = false;
        
        Scanner ent = new Scanner(System.in);
        ListaMemoria memLivre = new ListaMemoria();
        ListaMemoria memAlocada = new ListaMemoria();
        
        System.out.println("******* SIMULADOR DE MEMORIA *******");
        System.out.println();
        
        System.out.print("Digite a quantidade de memoria disponivel Total: ");
        int mem = ent.nextInt();
        
        memLivre.addOrdenadoLivre(0, mem);
        
        while(!fimProcessamento){
            char opcao = ' ';
            int proc = 0;
            System.out.println();
            System.out.println("O que você deseja fazer?");
            System.out.println();
            System.out.println("1 - Criar novo processo ");
            System.out.println("2 - Finalizar processo");
            System.out.println("3 - Imprimir situacao atual da memoria");
            System.out.println("9 - Sair");
            System.out.println();
            System.out.print("Digite a opcao desejada: ");
            opcao = ent.next().charAt(0);
            
            switch (opcao){
                case '1':
                    System.out.print("Digite o numero do processo que deseja criar: ");
                    proc = ent.nextInt();
                    if(!memAlocada.buscaProcessoIgual(proc)){
                        System.out.print("Informe a quantidade necessaria de memoria: ");
                        mem = ent.nextInt();
                        criarProcesso(proc, mem, memLivre, memAlocada);
                    }else{
                        System.out.println();
                        System.out.println("Erro ao criar novo processo.");
                        System.out.println("Motivo: Este numero de processo já existe!");
                    }
                    break;
                case '2':
                    System.out.print("Digite o numero do processo que deseja finalizar: ");
                    proc = ent.nextInt();
                    if(memAlocada.buscaProcessoIgual(proc)){
                        finalizarProcesso(proc, memLivre, memAlocada);
                    }else{
                        System.out.println();
                        System.out.println("Erro ao finalizar processo.");
                        System.out.println("Motivo: Numero de processo nao encontrado!");
                    }
                    break;
                case '3':
                    imprimir(memLivre, memAlocada);
                    break;
                case '9':
                    fimProcessamento = true;
                    break;
                default:
                    System.out.println("Opcao Invalida!");
            }
            
            
        }
        
    }
    
    public static void criarProcesso(int proc, int tam, 
            ListaMemoria memLivre, ListaMemoria memAlocada){
        
        Bloco livre;
        livre = memLivre.verMemLivre(tam);
        if(livre != null){
            memAlocada.addOrdenadoAlocado(proc, tam, livre);
            memLivre.subtrai(tam, livre);
            System.out.println("Processo criado com sucesso!");
        }else{
            System.out.println("Não foi possivel criar o processo solicitado.");
            System.out.println("Motivo: Não há espaço em memoria suficiente!");
        }
        
        
    }
    
    public static void finalizarProcesso(int proc, ListaMemoria memLivre, 
            ListaMemoria memAlocada){
        
        Bloco alocado = memAlocada.removeAlocado(proc);
        memLivre.addOrdenadoLivre(alocado.getEndInicial(), alocado.getQtdMemoria());
        System.out.println("Processo liberado com sucesso!");
    }
    
    public static void imprimir(ListaMemoria memLivre, ListaMemoria memAlocada){
        int qtdBlocosLivres = memLivre.getQtdBlocos();
        int qtdBlocosAlocados = memAlocada.getQtdBlocos();
        
        System.out.println();
        System.out.println("Quantidade de blocos livres: " + qtdBlocosLivres);
        if(qtdBlocosLivres > 0){
            System.out.println();
            System.out.println("Bloco   end_Inicial   qtdMemoria");
            for(int i=0; i < qtdBlocosLivres; i++){
                System.out.printf("%04d", i+1);
                System.out.print("    ");
                System.out.printf("%08d", memLivre.getBloco(i).getEndInicial());
                System.out.print("      ");
                System.out.printf("%08d", memLivre.getBloco(i).getQtdMemoria());
                System.out.println();
            }
        }
        
        System.out.println();
        System.out.println("Quantidade de blocos Alocados: " + qtdBlocosAlocados);
        
        if(qtdBlocosAlocados > 0){
            System.out.println();
            System.out.println("Bloco   end_Inicial   qtdMemoria   numProcesso");
            for(int i=0; i < qtdBlocosAlocados; i++){
                System.out.printf("%04d", i+1);
                System.out.print("    ");
                System.out.printf("%08d", memAlocada.getBloco(i).getEndInicial());
                System.out.print("      ");
                System.out.printf("%08d", memAlocada.getBloco(i).getQtdMemoria());
                System.out.print("     ");
                System.out.printf("%08d", memAlocada.getBloco(i).getNumeroProcesso());
                System.out.println();
            }
        }
        
    }
    
}
