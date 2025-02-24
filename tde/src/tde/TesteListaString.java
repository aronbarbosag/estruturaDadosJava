package tde;
import java.util.Scanner;

class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
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
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int buscar(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equalsIgnoreCase(nome)) {
                return i; 
            }
        }
        return -1; 
}
}

public class TesteListaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a capacidade da lista: ");
        int capacidade = scanner.nextInt();
        ListaArrayString lista = new ListaArrayString(capacidade);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar nome");
            System.out.println("2. Remover nome por índice");
            System.out.println("3. Imprimir lista de nomes");
            System.out.println("4. Buscar nome na lista");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome a ser adicionado: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    lista.adicionar(nome);
                    break;
                case 2:
                    System.out.print("Digite o índice do nome a ser removido: ");
                    int indice = scanner.nextInt();
                    lista.remover(indice);
                    break;
                case 3:
                    lista.imprimirLista();
                    break;
                case 4:
                    System.out.print("Digite o nome a ser buscado: ");
                    scanner.nextLine(); 
                    String nomeBusca = scanner.nextLine();
                    int posicao = lista.buscar(nomeBusca);
                    if (posicao != -1) {
                        System.out.println("Nome encontrado na posição: " + posicao);
                    } else {
                        System.out.println("Nome não encontrado na lista.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
       
    
