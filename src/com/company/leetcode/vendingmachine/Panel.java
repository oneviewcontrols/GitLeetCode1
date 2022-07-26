package com.company.leetcode.vendingmachine;

public interface Panel {

    public void priceButtonPushed(Product p);

    public void buyButtonPushed(String location,Product p);

    public void cancelButtonPushed();

    public void purchaseButtonPushed(Product p);

}
