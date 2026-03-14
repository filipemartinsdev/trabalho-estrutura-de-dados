package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static BubbleSort<Card> bubbleSort = new BubbleSort();
    public static InsertionSort<Card> insertionSort = new InsertionSort();
    public static SelectionSort<Card> selectionSort = new SelectionSort();

    public static final List<Card> baralho = new ArrayList<>(List.of(
            new Card('A', 1),
            new Card('2', 2),
            new Card('3', 3),
            new Card('4', 4),
            new Card('5', 5),
            new Card('6', 6),
            new Card('7', 7),
            new Card('8', 8),
            new Card('9', 9),
            new Card('J', 10),
            new Card('Q', 11),
            new Card('K', 12)
    ));

    public static void main( String[] args ) {



        while(true){
            System.out.println("JOGO DE CARTAS FODA");
            System.out.println("BARALHO FODA: ");
            Util.printCards(baralho);

            System.out.print("\nQUANTAS CARTAS PAE?\n> ");
            int cardCount = scanner.nextInt();
            scanner.nextLine();

            List<Card> cardList = getCards(cardCount);

            System.out.println("QUAL MÉTODO USAR PAE?");
            int resultMenu = printMenuAndWait();
            System.out.println("Sua mão: ");
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
                            scanner.nextLine().charAt(0)
                    )
            );
        }
        return cardList;
    }

    public static int printMenuAndWait(){
        while(true) {
            System.out.println("[1] Bubble Sort");
            System.out.println("[2] Insertion Sort");
            System.out.println("[3] Selection Sort");

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
            bubbleSort.sortPrintingCards(cardList);
            long end = System.currentTimeMillis();
            System.out.println("Tempo de execução: "+(end-start)+" ms");
        }
        else if (methodId == 2){
            long start = System.currentTimeMillis();
            selectionSort.sortPrintingCards(cardList);
            long end = System.currentTimeMillis();
            System.out.println("Tempo de execução: "+(end-start)+" ms");
        }
        else if (methodId == 3){
            long start = System.currentTimeMillis();
            insertionSort.sortPrintingCards(cardList);
            long end = System.currentTimeMillis();
            System.out.println("Tempo de execução: "+(end-start)+" ms");
        }
        else {
            return;
        }
    }
}
