package tde;

import java.util.Scanner;

class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // vazio aqui nessa bagaça
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public void imprimirPilha() {
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

public class TestePilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a capacidade da pilha: ");
        int capacidade = scanner.nextInt();
        Pilha pilha = new Pilha(capacidade);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Empilhar (push)");
            System.out.println("2. Desempilhar (pop)");
            System.out.println("3. Ver topo (peek)");
            System.out.println("4. Verificar se a pilha está vazia");
            System.out.println("5. Imprimir pilha");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser empilhado: ");
                    int elemento = scanner.nextInt();
                    pilha.push(elemento);
                    break;
                case 2:
                    int removido = pilha.pop();
                    if (removido != -1) {
                        System.out.println("Elemento removido: " + removido);
                    }
                    break;
                case 3:
                    int topo = pilha.peek();
                    if (topo != -1) {
                        System.out.println("Topo da pilha: " + topo);
                    }
                    break;
                case 4:
                    if (pilha.isEmpty()) {
                        System.out.println("VAZIO.");
                    } else {
                        System.out.println(" NÃO está VAZIO.");
                    }
                    break;
                case 5:
                    pilha.imprimirPilha();
                    break;
                case 6:
                    System.out.println("Programa Finalizado !!!!!!!!!!");
                    scanner.close();
                    return;
                default:
                    System.out.println("ERRO! Tente novamente.");
            }
        }
    }
}
