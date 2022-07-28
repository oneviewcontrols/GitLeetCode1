package com.company.leetcode.cards;

public abstract class Card <T> {
    protected T value;

    public Card(T value) {
        super();
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
