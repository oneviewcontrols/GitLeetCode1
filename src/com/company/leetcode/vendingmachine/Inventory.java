package com.company.leetcode.vendingmachine;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Inventory {
    private Map<String,Product> productMap = new HashMap<>();
    private int maxCapacity = 0;

    public Inventory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    protected abstract void loadInventory(List<Product> products);

    public boolean isEmpty() {
        return false;
    }

    public Collection<Product> getInventory() {
        return productMap.values();
    }

    public void add(String location,Product p) {

    }

    public Product remove(String location) {
        return null;
    }
}
