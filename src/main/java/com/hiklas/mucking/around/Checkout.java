package com.hiklas.mucking.around;

/**
 * Takes a list of items and produces an itemised receipt
 */
public class Checkout
{
  private PriceList priceList;

  public Checkout(PriceList priceList) {
    this.priceList = priceList;
  }
}
