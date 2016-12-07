package com.hiklas.mucking.around;

/**
 * Hold the price of a given item
 */
public class ItemPrice {

  private long id;
  private String description;
  private int priceInPence;

  public ItemPrice(long id, String description, int priceInPence) {
    this.id = id;
    this.description = description;
    this.priceInPence = priceInPence;
  }

  public long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public int getPriceInPence() {
    return priceInPence;
  }

}
