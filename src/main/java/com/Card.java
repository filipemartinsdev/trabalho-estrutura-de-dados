package com;

public record Card(char name, int value) implements Comparable<Card> {
    @Override
    public int compareTo(Card card) {
        return Integer.compare(value, card.value);
    }

    @Override
    public String toString() {
        return Util.getCardFormated(this);
    }

    @Override
    public boolean equals(Object card) {
        return value == ((Card)card).value;
    }
}
