package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static BubbleSort<Card> bubbleSort = new BubbleSort();
    public static SelectionSort<Card> selectionSort = new SelectionSort();
    public static InsertionSort<Card> insertionSort = new InsertionSort();

    public static final List<Card> baralho = new ArrayList<>(List.of(
            new Card("A", 1),
            new Card("2", 2),
            new Card("3", 3),
            new Card("4", 4),
            new Card("5", 5),
            new Card("6", 6),
            new Card("7", 7),
            new Card("8", 8),
            new Card("9", 9),
            new Card("10", 10),
            new Card("J", 11),
            new Card("Q", 12),
            new Card("K", 13)
    ));

    public static void main( String[] args ) {



        while(true){
            System.out.println(
                    """
                    \n
                    ╔═════════════════╗
                    ║    SORT GAME    ║
                    ╚═════════════════╝
                    """
            );
            System.out.println("[INFO] BARALHO:");
            Util.printCards(baralho);

            System.out.print("\n[?] Quantas cartas quer utilizar?\n> ");
            int cardCount = scanner.nextInt();
            scanner.nextLine();

            List<Card> cardList = getCards(cardCount);

            System.out.println("\n[?] Qual método de ordenação?");
            int resultMenu = printMenuAndWait();
            System.out.println("\n[INFO] SUA MÃO: ");
            Util.printCards(cardList);

            System.out.println();
            sortWithMethod(resultMenu, cardList);
            System.out.println();
        }
    }

    public static List<Card> getCards(int quantity){
        List<Card> cardList = new ArrayList<>();
        for(int i = 1; i <= quantity; i++){
            System.out.print("Carta "+i+": ");
            cardList.add(
                    Util.getCardByName(
                            scanner.nextLine()
                    )
            );
        }
        return cardList;
    }

    public static int printMenuAndWait(){
        while(true) {
            System.out.println("[1] Bubble Sort");
            System.out.println("[2] Selection Sort");
            System.out.println("[3] Insertion Sort");

            System.out.print("> ");
            int result = scanner.nextInt();
            scanner.nextLine();

            if (result > 0 && result <= 3) {
                return result;
            }

            System.out.println("[!] Opção inválida");
        }
    }

    public static void sortWithMethod(int methodId, List<Card> cardList){
        if (methodId == 1){
            long start = System.currentTimeMillis();
            System.out.println("[INFOS] Trocas:");
            bubbleSort.sortPrintingCards(cardList);
            long end = System.currentTimeMillis();
            System.out.println("[INFO] Tempo de execução: "+(end-start)+" ms");
        }
        else if (methodId == 2){
            long start = System.currentTimeMillis();
            System.out.println("[INFOS] Trocas:");
            selectionSort.sortPrintingCards(cardList);
            long end = System.currentTimeMillis();
            System.out.println("[INFO] Tempo de execução: "+(end-start)+" ms");
        }
        else if (methodId == 3){
            long start = System.currentTimeMillis();
            System.out.println("[INFOS] Trocas:");
            insertionSort.sortPrintingCards(cardList);
            long end = System.currentTimeMillis();
            System.out.println("[INFO] Tempo de execução: "+(end-start)+" ms");
        }
        else {
            return;
        }
    }
}
