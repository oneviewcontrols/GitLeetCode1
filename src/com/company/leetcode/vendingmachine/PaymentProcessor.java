package com.company.leetcode.vendingmachine;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public interface PaymentProcessor {

    public CurrencyType getType();

    public void processPayment(float cost) throws PaymentFailedException;


}
