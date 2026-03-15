package com;

import java.util.List;

public class SelectionSort<T extends Comparable> {
    public List<T> sort(List<T> list) {
        if (list == null || list.size() < 2) return list;

        for (int i = 0; i < list.size() - 1; i++) {
            int mi = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(mi)) < 0) {
                    mi = j;
                }
            }

            if (mi != i) {
                T min = list.get(mi);
                list.set(mi, list.get(i));
                list.set(i, min);
            }
        }

        return list;
    }

    public List<Card> sortPrintingCards(List<Card> list) {
        if (list == null || list.size() < 2) return list;

        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Card min = list.get(minIndex);
                list.set(minIndex, list.get(i));
                list.set(i, min);

                Util.printCards(list);
            }
        }

        return list;
    }
}