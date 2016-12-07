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

  public String createTheReceipt(long[] items) {
    for(long itemId: items) {
      ItemPrice itemPrice = priceList.getItemPrice(itemId);
    }
    return null;
  }
}
