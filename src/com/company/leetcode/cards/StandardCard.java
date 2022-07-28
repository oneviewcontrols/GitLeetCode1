package com.company.leetcode.cards;

public class StandardCard extends Card {
    private Suit suit;
    public StandardCard(Integer value, Suit suit) {
        super(value);
        this.suit = suit;
    }

    public Integer getValue() {
        return (Integer)super.getValue();
    }

    public Suit getSuit() {
        return this.suit;
    }


}
