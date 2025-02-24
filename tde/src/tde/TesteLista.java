package tde;
import java.util.Scanner;

class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void adicionarNaPosicao(int elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
      
        for (int i = tamanho; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
        tamanho++;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
   
}

public class TesteLista {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();
        ListaArray lista = new ListaArray(capacidade);
        
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar elemento ao final");
            System.out.println("2. Adicionar elemento em uma posição específica");
            System.out.println("3. Remover elemento de uma posição específica");
            System.out.println("4. Imprimir lista");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int elemento = scanner.nextInt();
                    lista.adicionar(elemento);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    lista.adicionarNaPosicao(valor, posicao);
                    break;
                case 3:
                    System.out.print("Digite a posição do elemento a ser removido: ");
                    int posRemover = scanner.nextInt();
                    lista.remover(posRemover);
                    break;
                case 4:
                	  lista.imprimirLista();
                     
                    break;
                case 5:
                    System.out.println("Fim do Programa");
                    scanner.close();
                    return;
                default:
                    System.out.println("Erro! opcao nao reconecida.");
            }
        }
    }

    }
