package com;

import java.util.List;

public class Util {
    public static String getCardFormated(Card card) {
//        return "+---+\n"+ "| "+card.name()+" |\n"+ "+---+\n";

        return "╔═══╗\n"+"║ "+card.name()+" ║\n"+"╚═══╝\n";
    }

    public static void printCard(Card card){
        System.out.print(
                "╔═══╗\n"+"║ "+card.name()+" ║\n"+"╚═══╝\n"
        );
    }
    public static void printCards(List<Card> cards){
        for (Card card : cards){
            System.out.print("╔═══╗ ");
        }

        System.out.println();

        for (Card card : cards){
            System.out.print("║ "+
                    (card.name().length() == 2 ? card.name() : card.name()+" ")
                    +"║ ");
        }

        System.out.println();

        for (Card card : cards){
            System.out.print("╚═══╝ ");
        }

        System.out.println();
    }

    public static Card getCardByName(String name){
        return switch (name){
            case "A", "a" -> new Card("A", 1);
            case "2" -> new Card("2", 2);
            case "3" -> new Card("3", 3);
            case "4" -> new Card("4", 4);
            case "5" -> new Card("5", 5);
            case "6" -> new Card("6", 6);
            case "7" -> new Card("7", 7);
            case "8" -> new Card("8", 8);
            case "9" -> new Card("9", 9);
            case "10" -> new Card("10", 10);
            case "J", "j" -> new Card("J", 11);
            case "Q", "q" -> new Card("Q", 12);
            case "K", "k" -> new Card("K", 13);
            default -> new Card("?", 0);
        };
    }
}
