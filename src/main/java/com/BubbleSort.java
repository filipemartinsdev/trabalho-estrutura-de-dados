package com;

import java.util.List;

public class BubbleSort<T extends Comparable> {
    public List<T> sort(List<T> list) {
        if (list == null || list.size() < 2) return list;

        boolean tr;

        for (int i = 0; i < list.size() - 1; i++) {
            tr = false;

            for (int j = 0; j < list.size() - 1 - i; j++) {
                T current = list.get(j);
                T next = list.get(j + 1);

                if (current.compareTo(next) > 0) {
                    list.set(j, next);
                    list.set(j + 1, current);

                    tr = true;
                }
            }

            if (!tr) {
                break;
            }
        }

        return list;
    }

    public List<Card> sortPrintingCards(List<Card> list) {
        if (list == null || list.size() < 2) return list;

        boolean swapped;

        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;

            for (int j = 0; j < list.size() - 1 - i; j++) {
                Card current = list.get(j);
                Card next = list.get(j + 1);

                if (current.compareTo(next) > 0) {
                    list.set(j, next);
                    list.set(j + 1, current);

                    Util.printCards(list);

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return list;
    }
}