package com;

import java.util.List;

public class SelectionSorte<T extends Comparable> {
    public List<T> sort(List<T> list) {
        if (list == null || list.size() < 2) return list;

        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }

        return list;
    }

    public List<Card> sortPrintingCards(List<Card> list) {
        if (list == null || list.size() < 2) return list;

        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                Card current = list.get(j);
                Card previous = list.get(j - 1);

                if (current.compareTo(previous) < 0) {
                    list.set(j, previous);
                    list.set(j - 1, current);

                    Util.printCards(list);
                } else {
                    break;
                }
            }
        }
        return list;
    }
}