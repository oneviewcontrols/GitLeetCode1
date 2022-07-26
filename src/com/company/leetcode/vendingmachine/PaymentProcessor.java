package com.company.leetcode.vendingmachine;

public interface PaymentProcessor {

    public CurrencyType getType();

    public void processPayment(float cost) throws PaymentFailedException;


}
