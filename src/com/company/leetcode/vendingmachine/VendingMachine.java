package com.company.leetcode.vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class VendingMachine {
    protected Map<CurrencyType,PaymentProcessor> pp = new HashMap<>();
    protected Inventory inventory;

    public VendingMachine(List<PaymentProcessor> pps,Panel panel,Inventory inventory) {
        super();
        //.....
    }

    public void buy(String location) {

    }

}
