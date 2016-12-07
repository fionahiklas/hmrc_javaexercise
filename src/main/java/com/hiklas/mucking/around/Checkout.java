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
    StringBuffer receiptText = new StringBuffer();
    int runningTotal = 0;

    for(long itemId: items) {
      ItemPrice itemPrice = priceList.getItemPrice(itemId);
      runningTotal += itemPrice.getPriceInPence();
      receiptText.append(lineItem(itemPrice.getDescription(), itemPrice.getPriceInPence()));
    }
    receiptText.append(total(runningTotal));
    return receiptText.toString();
  }

  private String lineItem(String description, int priceInPence) {
    return String.format("%s %d\n", description, priceInPence);
  }

  private String total(int totalInPence) {
    return String.format("TOTAL: %d", totalInPence);
  }
}
