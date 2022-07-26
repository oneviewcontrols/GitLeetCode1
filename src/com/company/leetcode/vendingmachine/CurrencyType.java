package com.company.leetcode.vendingmachine;

public enum CurrencyType {
        PENNY(1),NICKEL(5),QUARTER(25),DOLLAR(100);
        private int value;
        CurrencyType(int value) {
        this.value = value;
        }
        public void setValue(int value) {
            this.value = value;
        }
}
