package com.company.leetcode.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class CashPaymentProcessor implements PaymentProcessor {
    private Map<CurrencyType,Integer> cash = new HashMap<>();

    public float getAvailableCash() {
        return 0;
    }

    public boolean canProcessPayment(float amount) {
        return true;
    }


    @Override
    public void processPayment(float cost) throws PaymentFailedException {

    }
}
