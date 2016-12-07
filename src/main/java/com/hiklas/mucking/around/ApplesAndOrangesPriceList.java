package com.hiklas.mucking.around;

import java.util.HashMap;

/**
 * Implementation of the price list that just holds the apple and
 * orange items.
 */
public class ApplesAndOrangesPriceList implements PriceList {

  public static final long APPLE_ID = 65;
  public static final long ORANGE_ID = 79;

  private static final ItemPrice applePrice = new ItemPrice(APPLE_ID, "Apple", 60);
  private static final ItemPrice orangePrice = new ItemPrice(ORANGE_ID, "Orange", 25);
  private HashMap<Long, ItemPrice> priceList;

  public ApplesAndOrangesPriceList() {
    priceList = new HashMap<Long, ItemPrice>();
    priceList.put(APPLE_ID, applePrice);
    priceList.put(ORANGE_ID, orangePrice);
  }

  public ItemPrice getItemPrice(long id) {
    return priceList.get(id);
  }
}
